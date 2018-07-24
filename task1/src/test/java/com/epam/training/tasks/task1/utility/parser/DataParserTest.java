package com.epam.training.tasks.task1.utility.parser;

import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.model.entity.Point;
import com.epam.training.tasks.task1.utility.validator.DataValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    private static final String FILE_NAME = "src/main/resources/PyramidPoints.txt";
    private DataParser dataParser = new DataParser();
    @Test(expected = NullPointsDataException.class)
    public void shouldReturtFileNotFoundExceptionWhenFileDoNotExist() throws NullPointsDataException{
        dataParser.parseData(null);
    }


    @Test
    public void shouldReturnListWithArrayWithFivesPointWhenParseOnString() throws NullPointsDataException {
        List<String> coordinates = new ArrayList<String>();
        coordinates.add(" 1 1 0; 3 1 0; 3 3 0; 1 3 0; 2 2 2;");
        List<Point[]> result = dataParser.parseData(coordinates);
        int arrSize = result.get(0).length;
        Assert.assertEquals(arrSize, 5);
    }
}
