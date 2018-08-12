package com.epam.training.tasks.task3.utility.validator;

import com.epam.training.tasks.task3.exception.GreenHouseAppException;
import com.epam.training.tasks.task3.utility.validator.DataValidator;
import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {
    private static final String fileXML = "src/test/resources/flowers.xml";
    private static final String fileXSD = "src/test/resources/flowers.xsd";
    private static final String invalidFile = "src/test/resources/invalidXML.xml";

    private DataValidator dataValidator = new DataValidator();

    @Test
    public void shouldReturnTrueWhenFailXMLValid() {
        boolean actual = dataValidator.validateData(fileXML, fileXSD);
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseWhenFileXMLInvalid() {
        boolean actual = dataValidator.validateData(invalidFile, fileXSD);
        Assert.assertFalse(actual);
    }
}
