package com.epam.training.tasks.task2.utility.creator;

import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import com.epam.training.tasks.task2.model.builder.AbstractTaxiBuilder;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import com.epam.training.tasks.task2.model.factory.TaxiFactory;
import com.epam.training.tasks.task2.model.factory.TypeOfTaxi;
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
    private AbstractTaxiBuilder abstractTaxiBuilder;

    public TaxiParkCreator(DataReader dataReader,
                           DataValidator dataValidator,
                           DataParser dataParser,
                           TaxiFactory taxiFactory,
                           AbstractTaxiBuilder abstractTaxiBuilder) {
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
        this.dataParser = dataParser;
        this.taxiFactory = taxiFactory;
        this.abstractTaxiBuilder = abstractTaxiBuilder;
    }

    public TaxiPark createTaxiPark(String fileName) {
        final String nameOfFieldType = "type";

        TaxiPark taxiPark = new TaxiPark();
        AbstractTaxi abstractTaxi;
        String taxiType;
        TypeOfTaxi typeOfTaxi;
        AbstractTaxiBuilder abstractTaxiBuilder;

        try {
            List<String> listOfReadedStrings = dataReader.readData(fileName);

            List<String> listOfValidStrings = dataValidator.validateData(listOfReadedStrings);

            List<Map<String, String>> listOfObjectsFiels = dataParser.parseData(listOfValidStrings);

            for (Map<String, String> data : listOfObjectsFiels) {

                taxiType = data.get(nameOfFieldType);
                taxiType = taxiType.toUpperCase();
                typeOfTaxi = TypeOfTaxi.valueOf(taxiType);

                abstractTaxiBuilder = taxiFactory.factoryMethod(typeOfTaxi);
                abstractTaxi = abstractTaxiBuilder.create(data);

                taxiPark.addTaxi(abstractTaxi);
            }
        }
        catch (TaxiParkAppException e) {
            log.error(e.getMessage(), e);
        }

        return taxiPark;
    }
}
