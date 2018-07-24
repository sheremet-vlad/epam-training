package com.epam.training.tasks.task1.utility.reader;

import com.epam.training.tasks.task1.exception.FileOfPointsNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataReaderTest {
    private static final String FILE_NAME = "src/main/resources/PyramidPoints.txt";
    private DataReader reader = new DataReader();
    @Test (expected = FileOfPointsNotFoundException.class)
    public void shouldReturtFileNotFoundExceptionWhenFileDoNotExist() throws FileOfPointsNotFoundException{
        reader.readPoints("");
    }


    @Test
    public void shouldReturnNotNullListOfPointWhenFileExist() throws FileOfPointsNotFoundException {
        List<String> result = reader.readPoints(FILE_NAME);
        Assert.assertNotNull(result);
    }
}
