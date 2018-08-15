package com.epam.training.tasks.task4.parser.builder;

import com.epam.training.tasks.task4.parser.*;

public class SentenceParserBuilder extends AbstractParserBuilder {
    @Override
    public AbstractParser buildParser() {
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();

        textParser.setSuccessor(paragraphParser);
        paragraphParser.setSuccessor(sentenceParser);
        sentenceParser.setSuccessor(null);

        return textParser;
    }
}
