package com.epam.training.tasks.task2.utility.reader;

import com.epam.training.tasks.task2.exception.DataFileNotFoundException;
import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {

    private DataReader dataReader = new DataReader();

    @Test
    public void shouldReturnListOfStringsReadedFromFile() throws TaxiParkAppException {
        
        String fileName = "src/test/resources/TestDataReader.txt";
        
        List<String> expectedList = new ArrayList<String>();
        
        expectedList.add("Line1");
        expectedList.add("Line2 and word");
        expectedList.add("Line3");

        List<String> actualList = dataReader.readData(fileName);
        
        Assert.assertEquals(actualList,expectedList);
    }

    @Test(expected = DataFileNotFoundException.class)
    public void shouldReturnDataFileNotFoundExceptionWhenFileNotFound() throws TaxiParkAppException{
        String fileName = ",,,,,";
        dataReader.readData(fileName);
    }
}
