package com.epam.training.tasks.task2.utility.parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataParserTest {
    @Test
    public void shouldReturnListOfMapsOfObjectsFields() {
        List<String> entryList = new ArrayList<String>();

        entryList.add("type = CargoTaxi; costByOneKM = 12; passengers = 2; taxiCost = 1500; landingCost = 8; capacityInKG = 800;");
        entryList.add("type = GroundTaxi; costByOneKM = 10; passengers = 8; taxiCost = 20000; landingCost = 5;");

        List<Map<String, String>> expectedList = addInfoToList();

        DataParser dataParser = new DataParser();
        List<Map<String, String>> actualList = dataParser.parseData(entryList);

        Assert.assertEquals(actualList, expectedList);
    }

    private List<Map<String, String>> addInfoToList() {
        List<Map<String, String>> expectedList = new ArrayList<Map<String, String>>();
        Map<String, String> objectField = new HashMap<String, String>();
        objectField.put("type", "CargoTaxi");
        objectField.put("costByOneKM", "12");
        objectField.put("passengers", "2");
        objectField.put("taxiCost", "1500");
        objectField.put("landingCost", "8");
        objectField.put("capacityInKG", "800");

        expectedList.add(objectField);

        objectField = new HashMap<String, String>();

        objectField.put("type", "GroundTaxi");
        objectField.put("costByOneKM", "10");
        objectField.put("passengers", "8");
        objectField.put("taxiCost", "20000");
        objectField.put("landingCost", "5");

        expectedList.add(objectField);

        return expectedList;
    }
}
