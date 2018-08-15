package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;

public class ParagraphParser extends AbstractParser {

    private static final String REGEX = "[\\w|\\W]*(\\.|\\?|\\!])";

    public Component parse(String text) {
        AbstractParser successor = getSuccessor();
        return makeParsing(successor,REGEX, text);
    }
}
