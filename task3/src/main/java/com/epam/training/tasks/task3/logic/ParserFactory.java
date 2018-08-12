package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.enumeration.TypeOfParser;
import com.epam.training.tasks.task3.exception.IllegalTypeOfParserException;

public class ParserFactory {

    public AbstractParser createParser(TypeOfParser typeOfParser) throws IllegalTypeOfParserException {

        AbstractParser abstractParser = null;
        switch (typeOfParser) {
            case DOM: {

            } break;

            default: {
                throw new IllegalTypeOfParserException("incorrect type of parser");
            }
        }

        return abstractParser;
    }
}
