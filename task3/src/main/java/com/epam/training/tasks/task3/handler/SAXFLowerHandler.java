package com.epam.training.tasks.task3.handler;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;
import com.epam.training.tasks.task3.model.entity.VisualParametr;
import org.xml.sax.Attributes;
import com.epam.training.tasks.task3.enumeration.FlowerEnum;
import com.epam.training.tasks.task3.model.entity.CarnivorousFlower;
import com.epam.training.tasks.task3.model.entity.Flower;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class SAXFLowerHandler extends DefaultHandler {

    private static final String FLOWER = "flower";
    private static final String CARNIVOROUS_FLOWR= "carnivorous_flower";
    private static final String VISUAL_PARAMETERS = "visual_parametr";

    private static final int INDEX_FIRST_ATTRIBUTE = 0;
    private static final int COUNT_ATTRIBUTES = 2;
    private static final int INDEX_SECOND_ATTRIBUTE = 1;

    private List<Flower> listOfFlower = new LinkedList<>();
    private Flower flower = null;
    private FlowerEnum currentEnum = null;
    private VisualParametr visualParametr = null;
    private EnumSet<FlowerEnum> withText;

    public SAXFLowerHandler() {
        FlowerEnum leftBreak = FlowerEnum.NAME;
        FlowerEnum rightBreak = FlowerEnum.DIGESTION_IN_SECONDS;
        withText = EnumSet.range(leftBreak, rightBreak);
    }
    public List<Flower> getFlowers() {
        return listOfFlower;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        if (FLOWER.equalsIgnoreCase(localName)) {
            flower = new Flower();
            flower.setOrigin(attrs.getValue(INDEX_FIRST_ATTRIBUTE));

            if (attrs.getLength() == COUNT_ATTRIBUTES) {
                String soil = attrs.getValue(INDEX_SECOND_ATTRIBUTE);
                flower.setTypeOfSoil(TypeOfSoil.valueOf(soil));
            }
        } else if (CARNIVOROUS_FLOWR.equalsIgnoreCase(localName)){
            flower = new CarnivorousFlower();
            flower.setOrigin(attrs.getValue(INDEX_FIRST_ATTRIBUTE));

            if (attrs.getLength() == COUNT_ATTRIBUTES) {
                String soil = attrs.getValue(INDEX_SECOND_ATTRIBUTE);
                flower.setTypeOfSoil(TypeOfSoil.valueOf(soil));
            }
        } else {
            String localNameUpperCase = localName.toUpperCase();
            FlowerEnum flowerEnum = FlowerEnum.valueOf(localNameUpperCase);
            if (withText.contains(flowerEnum)) {
                currentEnum = flowerEnum;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (VISUAL_PARAMETERS.equalsIgnoreCase(localName)) {
            flower.setVisualParametr(visualParametr);
        }
        if (FLOWER.equals(localName) || CARNIVOROUS_FLOWR.equals(localName)) {
            listOfFlower.add(flower);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String characteristic = new String(ch, start, length).trim();
        if (currentEnum != null){
            switch (currentEnum) {
                case NAME:
                    flower.setName(characteristic);
                    break;
                case VISUAL_PARAMETR:
                    visualParametr = new VisualParametr();
                    break;
                case STEM_COLOR:
                    visualParametr.setStemColor(characteristic);
                    break;
                case SHEET_COLOR:
                    visualParametr.setSheetColor(characteristic);
                    break;
                case AVERAGE_SIZE:
                    int average = Integer.parseInt(characteristic);
                    visualParametr.setAverageSize(average);
                    break;
                case DIGESTION_IN_SECONDS:
                    int digistation = Integer.parseInt(characteristic);
                    ((CarnivorousFlower) flower).setDigestionInSeconds(digistation);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
