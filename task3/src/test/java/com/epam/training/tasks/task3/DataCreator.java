package com.epam.training.tasks.task3;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;
import com.epam.training.tasks.task3.model.entity.CarnivorousFlower;
import com.epam.training.tasks.task3.model.entity.Flower;
import com.epam.training.tasks.task3.model.entity.VisualParametr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataCreator {
    private static final String NAME = "name";
    private static final String ORIGIN = "origin";
    private static final String STEM_COLOR = "stem_color";
    private static final String SHEET_COLOR = "sheet_color";
    private static final String AVERAGE_SIZE = "average_size";
    private static final String SOIL = "soil";
    private static final String DIGISTETION_NAME = "digestion_in_seconds";

    private static final int FIELDS_COUNT_FLOWER = 6;

    public static List<Flower> listCreator(String ... listOfParametrs) {
        List<Map<String, String>> listOfMaps = new LinkedList<>();
        String[] arrayOfParametrs;

        for (int i = 0; i < listOfParametrs.length; i++) {
            arrayOfParametrs = listOfParametrs[i].split(" ");
            listOfMaps.add(createMap(arrayOfParametrs));
        }

        List<Flower> flowers = createObjects(listOfMaps);

        return flowers;
    }

    private static Map<String, String> createMap(String[] listOfParametrs) {

        Map<String, String> mapOfParametrs = new HashMap<>();

        for (int i = 0; i < listOfParametrs.length; i += 2) {
            mapOfParametrs.put(listOfParametrs[i], listOfParametrs[i + 1]);
        }

        return mapOfParametrs;
    }

    private static List<Flower> createObjects(List<Map<String,String>> listOfMaps) {
        List<Flower> listOfFlower = new LinkedList<>();
        for (int i = 0; i < listOfMaps.size(); i++) {
            Map<String, String> mapsOfFields = listOfMaps.get(i);
            Flower flower;

            if (mapsOfFields.size() == FIELDS_COUNT_FLOWER) {
                flower = new Flower();
            }
            else {
                flower = new CarnivorousFlower();
                int dignestation = Integer.parseInt(mapsOfFields.get(DIGISTETION_NAME));
                ((CarnivorousFlower) flower).setDigestionInSeconds(dignestation);
            }

            flower.setName(mapsOfFields.get(NAME));

            String soil = mapsOfFields.get(SOIL);
            TypeOfSoil typeOfSoil = TypeOfSoil.valueOf(soil);
            flower.setTypeOfSoil(typeOfSoil);

            flower.setOrigin(mapsOfFields.get(ORIGIN));

            VisualParametr visualParametr = new VisualParametr();
            visualParametr.setSheetColor(mapsOfFields.get(SHEET_COLOR));
            visualParametr.setAverageSize(Integer.parseInt(mapsOfFields.get(AVERAGE_SIZE)));
            visualParametr.setStemColor(mapsOfFields.get(STEM_COLOR));

            flower.setVisualParametr(visualParametr);

            listOfFlower.add(flower);
        }

        return listOfFlower;
    }
}
