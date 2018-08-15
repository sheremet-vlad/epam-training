package com.epam.training.tasks.task4.parser.builder;

import com.epam.training.tasks.task4.parser.AbstractParser;
import com.epam.training.tasks.task4.parser.ParagraphParser;
import com.epam.training.tasks.task4.parser.SentenceParser;
import com.epam.training.tasks.task4.parser.TextParser;

public class ParagraphParserBuilder extends AbstractParserBuilder{
    @Override
    public AbstractParser buildParser() {
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(null);

        return textParser;
    }
}
