package com.epam.training.tasks.task4.utility.reader;

import com.epam.training.tasks.task4.exception.DataFileIOException;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {

    private final static DataReader dataReader = new DataReader();
    private final static String fileName = "src/test/resources/TestDataReader.txt";

    @Test
    public void shouldReturnTextFromFile() throws DataFileIOException {
        String actial = "It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
                "remaining 35+ essentially 6934-*+ unchanged. It was popularised in the 49756-+*/ \n" +
                "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n" +
                "publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                "\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. \n" +
                "The point of using lpsum is that it has a more-or-less normal \n" +
                "distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \n" +
                "\n" +
                "It is a 978i++34--*/+ established fact that a reader will be of a page when looking at its layout.";

        String expected = dataReader.readData(fileName);
        Assert.assertEquals(actial, expected);
    }
}