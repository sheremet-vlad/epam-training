package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;

public class TextParser extends AbstractParser {

    private final static String REGEX = "((.+\n)+\n)|(.+$)";

    public Component parse(String text) {
        AbstractParser successor = getSuccessor();
        return makeParsing(successor, REGEX, text);
    }
}
