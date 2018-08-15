package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;
import com.epam.training.tasks.task4.model.entity.Composite;
import com.epam.training.tasks.task4.model.entity.Leaf;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser {
    private AbstractParser successor = null;

    public void setSuccessor(AbstractParser abstractParser) {
        successor = abstractParser;
    }

    public AbstractParser getSuccessor() {
        return successor;
    }

    public abstract Component parse(String text);

    protected Component makeParsing(AbstractParser successor, String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> listOfStrings = new LinkedList<>();
        String partOfString;

        while (matcher.find()) {
            partOfString = matcher.group();
            listOfStrings.add(partOfString);
        }
        String string;
        Component composite = new Composite();

        if (successor != null) {
            Component component;
            for (int i = 0; i < listOfStrings.size(); i++) {
                string = listOfStrings.get(i);
                component = successor.parse(string);
                composite.add(component);
            }
        } else {
            Component leaf;
            for (int i = 0; i < listOfStrings.size(); i++) {
                string = listOfStrings.get(i);
                leaf = new Leaf(string);
                composite.add(leaf);
            }
        }

        return composite;
    }
}
