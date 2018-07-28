package com.epam.training.tasks.task2.utility.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataParser  {
    public List<Map<String, String>> parseData(List<String> listOfStings) {
        final int indexOfField = 0;
        final int indexOfValue = 1;
        List<Map<String,String>> listOfObjectsFields = new ArrayList<Map<String, String>>();
        HashMap<String, String> mapOfFields;
        String[] objectFields;
        String[] arrFieldAndValue;
        String tempLine;

        for (int i = 0; i < listOfStings.size(); i++) {
            tempLine = listOfStings.get(i);
            tempLine = tempLine.replaceAll(" ", ""); //delete all spaces
            objectFields = tempLine.split(";");

            mapOfFields = new HashMap<String, String>();

            for (int j = 0; j < objectFields.length; j++) {
                arrFieldAndValue = objectFields[j].split("=");
                mapOfFields.put(arrFieldAndValue[indexOfField], arrFieldAndValue[indexOfValue]);
            }

            listOfObjectsFields.add(mapOfFields);
        }

        return listOfObjectsFields;
    }
}
