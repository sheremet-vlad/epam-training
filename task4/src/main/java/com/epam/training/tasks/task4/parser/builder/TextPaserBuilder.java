package com.epam.training.tasks.task4.parser.builder;

import com.epam.training.tasks.task4.parser.AbstractParser;
import com.epam.training.tasks.task4.parser.TextParser;

public class TextPaserBuilder extends AbstractParserBuilder {
    @Override
    public AbstractParser buildParser() {
        TextParser textParser = new TextParser();

        textParser.setSuccessor(null);

        return textParser;
    }
}
