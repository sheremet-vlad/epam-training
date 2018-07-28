package com.epam.training.tasks.task2.utility.creator;

import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import com.epam.training.tasks.task2.model.factory.TaxiFactory;
import com.epam.training.tasks.task2.utility.parser.DataParser;
import com.epam.training.tasks.task2.utility.reader.DataReader;
import com.epam.training.tasks.task2.utility.validator.DataValidator;
import org.apache.log4j.Logger;

import java.io.Reader;
import java.util.List;
import java.util.Map;

public class TaxiParkCreator {

    private static final Logger log = Logger.getLogger(TaxiParkCreator.class);

    private DataReader dataReader;
    private DataValidator dataValidator;
    private DataParser dataParser;
    private TaxiFactory taxiFactory;

    public TaxiParkCreator(DataReader dataReader,
                           DataValidator dataValidator,
                           DataParser dataParser,
                           TaxiFactory taxiFactory) {
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
        this.dataParser = dataParser;
        this.taxiFactory = taxiFactory;
    }

    public TaxiPark createTaxiPark(String fileName) {

        TaxiPark taxiPark = new TaxiPark();

        try {
            List<String> listOfReadedStrings = dataReader.readData(fileName);

            List<String> listOfValidStrings = dataValidator.validateData(listOfReadedStrings);

            List<Map<String, String>> listOfObjectsFiels = dataParser.parseData(listOfValidStrings);

            AbstractTaxi abstractTaxi;


            for (Map<String, String> temp : listOfObjectsFiels) {
                abstractTaxi = taxiFactory.factoryMethod(temp);
                taxiPark.addTaxi(abstractTaxi);
            }
        }
        catch (TaxiParkAppException e) {
            log.error(e.getMessage(), e);
        }

        return taxiPark;
    }
}
