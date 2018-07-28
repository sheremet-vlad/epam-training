package com.epam.training.tasks.task2.utility.validator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {
    @Test
    public void shouldReturnListOfCorrectStrings() {
        List<String> entryList = new ArrayList<String>();
        entryList.add(" type = abc; afv = 47; aduu = jwdn; skjfvn = kad; afv = 47;");
        entryList.add(" type = abc; afv = 47; aduu = jwdn; skjfvn kad; afv = 47;");
        entryList.add(" type = abc; afv = 47; aduu = 48; skjfvn = kad; afv = 47;");
        entryList.add(" type = abc; afv = 47; aduu = jwdn; skjfvn = kad; afv = 47;");

        List<String> expectedList = new ArrayList<String>();
        expectedList.add(" type = abc; afv = 47; aduu = jwdn; skjfvn = kad; afv = 47;");
        expectedList.add(" type = abc; afv = 47; aduu = 48; skjfvn = kad; afv = 47;");
        expectedList.add(" type = abc; afv = 47; aduu = jwdn; skjfvn = kad; afv = 47;");

        DataValidator dataValidator = new DataValidator();
        List<String> actualList = dataValidator.validateData(entryList);

        Assert.assertEquals(expectedList, actualList);
    }
}
