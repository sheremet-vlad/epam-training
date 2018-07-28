package com.epam.training.tasks.task2.utility.creator;

import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import com.epam.training.tasks.task2.model.factory.TaxiFactory;
import com.epam.training.tasks.task2.utility.parser.DataParser;
import com.epam.training.tasks.task2.utility.reader.DataReader;
import com.epam.training.tasks.task2.utility.validator.DataValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TaxiParkCreatorTest {
    @Test
    public void shouldReturnListOfTaxiWithSizeOne() throws TaxiParkAppException {
        String fileName = "src/test/resources/TestDataReader.txt";
        List<String> listOfStrings = new ArrayList<String>();
        List<Map<String, String>> listOfObjectsFields = new ArrayList<Map<String, String>>();
        listOfObjectsFields.add(new HashMap<String, String>());
        Map<String, String> objectsFields = new HashMap<String, String>();

        DataReader dataReader = mock(DataReader.class);
        when(dataReader.readData(fileName)).thenReturn(listOfStrings);

        DataValidator dataValidator = mock(DataValidator.class);
        when(dataValidator.validateData(listOfStrings)).thenReturn(listOfStrings);

        DataParser dataParser = mock(DataParser.class);
        when(dataParser.parseData(listOfStrings)).thenReturn(listOfObjectsFields);

        TaxiFactory taxiFactory = mock(TaxiFactory.class);
        when(taxiFactory.factoryMethod(objectsFields)).thenReturn(new CargoTaxi(4,5,6,7,8));

        TaxiParkCreator taxiParkCreator = new TaxiParkCreator(dataReader, dataValidator, dataParser, taxiFactory);

        TaxiPark taxiPark = taxiParkCreator.createTaxiPark(fileName);
        List<AbstractTaxi> listOfTaxi = taxiPark.getListOfTaxi();

        int sizeOfTaxiParking = listOfTaxi.size();

        Assert.assertEquals(sizeOfTaxiParking, 1);
    }
}
