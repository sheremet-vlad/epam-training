package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;
import com.epam.training.tasks.task3.exception.DataFileIOException;
import com.epam.training.tasks.task3.model.entity.CarnivorousFlower;
import com.epam.training.tasks.task3.model.entity.Flower;
import com.epam.training.tasks.task3.model.entity.VisualParametr;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.*;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser extends AbstractParser{
    private static final String NAME = "name";
    private static final String ORIGIN = "origin";
    private static final String VISUAL_PARAMETERS = "visual_parametr";
    private static final String STEM_COLOR = "stem_color";
    private static final String SHEET_COLOR = "sheet_color";
    private static final String AVERAGE_SIZE = "average_size";
    private static final String SOIL = "soil";
    private static final String DIGISTETION = "digestion_in_seconds";
    private static final String FLOWER = "flower";
    private static final String CARNIVOROUS_FLOWR= "carnivorous_flower";

    private static final Logger log = Logger.getLogger(StaxParser.class);
    private static final String LOG_PROPERTIES = "src/main/resources/log4j_properties.properties";

    @Override
    public List<Flower> parse(String fileName) {
        PropertyConfigurator.configure(LOG_PROPERTIES);

        List<Flower> listOfFlowers = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc;
        try {
            DocumentBuilder docBuilder = factory.newDocumentBuilder();

            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList flowersList = root.getElementsByTagName(FLOWER);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildFlower(flowerElement);
                listOfFlowers.add(flower);
            }

            flowersList = root.getElementsByTagName(CARNIVOROUS_FLOWR);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildCarnivorousFlower(flowerElement);
                listOfFlowers.add(flower);
            }

        } catch (ParserConfigurationException e) {
            log.error("parser Dom configuration exception");
        } catch (IOException e) {
            log.error(new DataFileIOException("data file exception"));
        } catch (SAXException e) {
            log.error("Dom parsing exception");
        }

        return listOfFlowers;
    }

    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();

        flower.setOrigin(flowerElement.getAttribute(ORIGIN));

        String soil = flowerElement.getAttribute(SOIL);
        TypeOfSoil typeOfSoil = TypeOfSoil.valueOf(soil);
        flower.setTypeOfSoil(typeOfSoil);

        flower.setName(getElementTextContent(flowerElement,NAME));

        Element visualProperties = (Element) flowerElement.getElementsByTagName(VISUAL_PARAMETERS).item(0);

        VisualParametr visualParametr = new VisualParametr();

        visualParametr.setAverageSize(Integer.parseInt(getElementTextContent(visualProperties, AVERAGE_SIZE)));
        visualParametr.setSheetColor(getElementTextContent(visualProperties, SHEET_COLOR));
        visualParametr.setStemColor(getElementTextContent(visualProperties, STEM_COLOR));

        flower.setVisualParametr(visualParametr);

        return flower;
    }

    private Flower buildCarnivorousFlower(Element flowerElement) {
        CarnivorousFlower flower = new CarnivorousFlower();

        flower.setOrigin(flowerElement.getAttribute(ORIGIN));

        String soil = flowerElement.getAttribute(SOIL);
        TypeOfSoil typeOfSoil = TypeOfSoil.valueOf(soil);
        flower.setTypeOfSoil(typeOfSoil);

        flower.setDigestionInSeconds(Integer.parseInt(getElementTextContent(flowerElement,DIGISTETION)));

        Element visualProperties = (Element) flowerElement.getElementsByTagName(VISUAL_PARAMETERS).item(0);

        flower.setName(getElementTextContent(flowerElement,NAME));

        VisualParametr visualParametr = new VisualParametr();

        visualParametr.setAverageSize(Integer.parseInt(getElementTextContent(visualProperties, AVERAGE_SIZE)));
        visualParametr.setSheetColor(getElementTextContent(visualProperties, SHEET_COLOR));
        visualParametr.setStemColor(getElementTextContent(visualProperties, STEM_COLOR));

        flower.setVisualParametr(visualParametr);

        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
