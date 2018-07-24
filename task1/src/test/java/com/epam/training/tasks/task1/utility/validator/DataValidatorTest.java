package com.epam.training.tasks.task1.utility.validator;

import com.epam.training.tasks.task1.exception.FileOfPointsNotFoundException;
import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.utility.parser.DataParser;
import com.epam.training.tasks.task1.utility.reader.DataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {

    private DataValidator dataValidator = new DataValidator();
    @Test(expected = NullPointsDataException.class)
    public void shouldReturtFileNotFoundExceptionWhenFileDoNotExist() throws NullPointsDataException{
        dataValidator.validateData(null);
    }


    @Test
    public void shouldReturnListWithSizOneWhenSecondStringInvalid() throws NullPointsDataException {
        List<String> result = new ArrayList<String>();
        result.add(" 1 1 0; 3 1 0; 3 3 0; 1 3 0; 2 2 2;");
        result.add(" 1 1 0; 3 1 0; 3 3 0; 1 3 0; 2 2dfdfd 2;");
        result = dataValidator.validateData(result);
        int size = result.size();
        Assert.assertEquals(size, 1);
    }
}
