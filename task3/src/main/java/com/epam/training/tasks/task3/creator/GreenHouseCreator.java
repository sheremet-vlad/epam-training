package com.epam.training.tasks.task3.creator;

import com.epam.training.tasks.task3.enumeration.TypeOfParser;
import com.epam.training.tasks.task3.enumeration.TypeOfSoil;
import com.epam.training.tasks.task3.exception.DataParseException;
import com.epam.training.tasks.task3.exception.DataValidationException;
import com.epam.training.tasks.task3.exception.GreenHouseAppException;
import com.epam.training.tasks.task3.logic.AbstractParser;
import com.epam.training.tasks.task3.logic.ParserFactory;
import com.epam.training.tasks.task3.model.entity.Flower;
import com.epam.training.tasks.task3.utility.validator.DataValidator;

import java.text.ParseException;
import java.util.List;

public class GreenHouseCreator {
    public List<Flower> createGreenHouse(String fileXML, String fileXSD, TypeOfParser typeOfParser) throws GreenHouseAppException {
            DataValidator dataValidator = new DataValidator();
            if (!dataValidator.validateData(fileXML, fileXSD)){
                throw new DataValidationException("file xml is invalid");
            }
            ParserFactory parserFactory = new ParserFactory();
            AbstractParser abstractParser = parserFactory.createParser(typeOfParser);
            List<Flower> listOfFlowr = abstractParser.parse(fileXML);

            if (listOfFlowr == null) {
                throw new DataParseException("parse is crash");
            }

            return listOfFlowr;
    }
}
