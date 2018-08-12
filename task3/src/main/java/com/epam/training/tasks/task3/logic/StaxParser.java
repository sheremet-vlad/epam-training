package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;
import com.epam.training.tasks.task3.exception.DataFileIOException;
import com.epam.training.tasks.task3.model.entity.CarnivorousFlower;
import com.epam.training.tasks.task3.model.entity.Flower;
import com.epam.training.tasks.task3.model.entity.VisualParametr;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StaxParser extends AbstractParser {

    private static final String NAME = "name";
    private static final String VISUAL_PARAMETERS = "visual_parametr";
    private static final String STEM_COLOR = "stem_color";
    private static final String SHEET_COLOR = "sheet_color";
    private static final String AVERAGE_SIZE = "average_size";
    private static final String DIGISTETION = "digestion_in_seconds";
    private static final String FLOWER = "flower";
    private static final String CARNIVOROUS_FLOWR= "carnivorous_flower";

    private static final Logger log = Logger.getLogger(StaxParser.class);
    private static final String LOG_PROPERTIES = "src/main/resources/log4j_properties.properties";

    private boolean isName = false;
    private boolean isStemColor = false;
    private boolean isSheetColor = false;
    private boolean isAverageSize = false;
    private boolean isVisualParametrs = false;
    private boolean isDigistation = false;

    private String currentElement;
    private Flower flower;
    private VisualParametr visualParametr;
    private List<Flower> listOfFLower = new LinkedList<>();

    public List<Flower> parse(String fileName) {
        PropertyConfigurator.configure(LOG_PROPERTIES);

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(fileName));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch(event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {
                        startElement(event);
                    } break;
                    case XMLStreamConstants.CHARACTERS: {
                        characters(event);
                    } break;
                    case XMLStreamConstants.END_ELEMENT: {
                        endElement(event);
                    } break;
                }
            }

        } catch (IOException e) {
            log.error(new DataFileIOException(e.getMessage(), e));
        } catch (XMLStreamException e) {
            log.error(e.getMessage(), e);
        }

        return listOfFLower;
    }

    private void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        currentElement = startElement.getName().getLocalPart();

        if (currentElement.equalsIgnoreCase(FLOWER)) {
            flower = new Flower();
            Iterator<Attribute> attributes = startElement.getAttributes();
            String origin = attributes.next().getValue();
            String soil = attributes.next().getValue();
            TypeOfSoil typeOfSoil = TypeOfSoil.valueOf(soil);

            flower.setOrigin(origin);
            flower.setTypeOfSoil(typeOfSoil);

        } else if (currentElement.equalsIgnoreCase(CARNIVOROUS_FLOWR)){
            flower = new CarnivorousFlower();
            Iterator<Attribute> attributes = startElement.getAttributes();
            String origin = attributes.next().getValue();
            String soil = attributes.next().getValue();
            TypeOfSoil typeOfSoil = TypeOfSoil.valueOf(soil);

            flower.setOrigin(origin);
            flower.setTypeOfSoil(typeOfSoil);

        } else if (currentElement.equalsIgnoreCase(NAME)) {
            isName = true;
        } else if (currentElement.equalsIgnoreCase(VISUAL_PARAMETERS)) {
            isVisualParametrs = true;
        } else if (currentElement.equalsIgnoreCase(SHEET_COLOR)) {
            isSheetColor = true;
        } else if (currentElement.equalsIgnoreCase(STEM_COLOR)) {
            isStemColor= true;
        } else if (currentElement.equalsIgnoreCase(AVERAGE_SIZE)) {
            isAverageSize = true;
        } else if (currentElement.equalsIgnoreCase(DIGISTETION)) {
            isDigistation = true;
        }
    }

    public void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        String dataCharacteristic = characters.getData();
        if(isName) {
            flower.setName(dataCharacteristic);
            isName = false;
        }
        if(isAverageSize) {
            int averageSize = Integer.parseInt(dataCharacteristic);
            visualParametr.setAverageSize(averageSize);
            isAverageSize = false;
        }
        if(isDigistation) {
            int digistation = Integer.parseInt(dataCharacteristic);
            ((CarnivorousFlower) flower).setDigestionInSeconds(digistation);
            isDigistation = false;
        }
        if(isSheetColor) {
            visualParametr.setSheetColor(dataCharacteristic);
            isSheetColor = false;
        }
        if(isStemColor) {
            visualParametr.setStemColor(dataCharacteristic);
            isStemColor = false;
        }
        if(isVisualParametrs) {
            visualParametr = new VisualParametr();
            isVisualParametrs = false;
        }
    }

    private void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        currentElement = endElement.getName().getLocalPart();

        if(currentElement.equalsIgnoreCase(VISUAL_PARAMETERS)) {
            flower.setVisualParametr(visualParametr);
        }
        if(currentElement.equalsIgnoreCase(FLOWER)
                || currentElement.equalsIgnoreCase(CARNIVOROUS_FLOWR)) {
            listOfFLower.add(flower);
        }
    }
}
