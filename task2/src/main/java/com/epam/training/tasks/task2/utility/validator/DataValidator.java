package com.epam.training.tasks.task2.utility.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private static final String REGEX  = "^(\\s?[a-zA-Z]+\\s?=\\s?([a-zA-Z]+|\\d+)\\s?;){5,6}$";

    public List<String> validateData(List<String> entryList) throws NullPointerException {

        if (entryList == null || entryList.size() == 0) {
            throw new NullPointerException("Null pointer transfer to method validateData");
        }

        List<String> validateStrings = new ArrayList<String>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher;
        for (String tempString : entryList) {
            matcher = pattern.matcher(tempString);
            if (matcher.matches()) {
                validateStrings.add(tempString);
            }
        }

        return validateStrings;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(" type = abc; afv = 47; aduu = jwdn; skjfvn = kad;");
        System.out.println(matcher.matches());
    }
}
