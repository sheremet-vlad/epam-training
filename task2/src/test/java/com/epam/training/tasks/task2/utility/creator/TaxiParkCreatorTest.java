package com.epam.training.tasks.task2.utility.creator;

import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import com.epam.training.tasks.task2.model.builder.AbstractTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.AirTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.CargoTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.GroundTaxiBuilder;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import com.epam.training.tasks.task2.model.factory.TaxiFactory;
import com.epam.training.tasks.task2.model.factory.TypeOfTaxi;
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
    private String fileName = "src/test/resources/TestDataReader.txt";
    private List<String> listOfStrings = new ArrayList<String>();
    private final Map<String, String> objectsFields = new HashMap<>();
    private List<Map<String, String>> listOfObjectsFields = new ArrayList<Map<String, String>>();
    
    @Test
    public void shouldReturnListOfTaxiWithSizeOne() throws TaxiParkAppException {
        addData();

        DataReader dataReader = mock(DataReader.class);
        when(dataReader.readData(fileName)).thenReturn(listOfStrings);

        DataValidator dataValidator = mock(DataValidator.class);
        when(dataValidator.validateData(listOfStrings)).thenReturn(listOfStrings);

        DataParser dataParser = mock(DataParser.class);
        when(dataParser.parseData(listOfStrings)).thenReturn(listOfObjectsFields);

        TaxiFactory taxiFactory = mock(TaxiFactory.class);
        when(taxiFactory.factoryMethod(TypeOfTaxi.GROUND_TAXI)).thenReturn(new GroundTaxiBuilder());

        AbstractTaxiBuilder abstractTaxiBuilder = mock(AbstractTaxiBuilder.class);
        when(abstractTaxiBuilder.create(objectsFields)).thenReturn(new CargoTaxi());

        TaxiParkCreator taxiParkCreator = new TaxiParkCreator(dataReader, dataValidator, dataParser, taxiFactory, abstractTaxiBuilder);

        TaxiPark taxiPark = taxiParkCreator.createTaxiPark(fileName);
        List<AbstractTaxi> listOfTaxi = taxiPark.getListOfTaxi();

        int sizeOfTaxiParking = listOfTaxi.size();

        Assert.assertEquals(sizeOfTaxiParking, 1);
    }

    private void addData() {
        objectsFields.put("type", "Ground_Taxi");
        objectsFields.put("costByOneKM", "10");
        objectsFields.put("passengers", "8");
        objectsFields.put("taxiCost", "20000");
        objectsFields.put("landingCost", "5");
        listOfObjectsFields.add(objectsFields);
    }



}
