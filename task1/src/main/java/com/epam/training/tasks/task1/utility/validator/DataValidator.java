package com.epam.training.tasks.task1.utility.validator;

import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.model.entity.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String REGEX = "^((\\s-?\\d){3};){5}$";

    public List<String> validateData(List<String> linesOfPoints) throws NullPointsDataException{
        if (linesOfPoints == null) {
            throw new NullPointsDataException("List of point is empty");
        }
        List<String> validLines = new ArrayList<String>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher;

        for (int i = 0; i < linesOfPoints.size(); i++) {
            matcher = pattern.matcher(linesOfPoints.get(i));

            if (matcher.matches()){
                validLines.add(linesOfPoints.get(i));
            }
        }

        return validLines;
    }

}
