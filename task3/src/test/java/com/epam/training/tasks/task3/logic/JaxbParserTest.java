package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.DataCreator;
import com.epam.training.tasks.task3.model.entity.Flower;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JaxbParserTest {
    private static final String fileName = "src/test/resources/flowers.xml";

    private static final JaxbParser jaxbParser = new JaxbParser();

    private static final List<Flower> expectedList = DataCreator.listCreator(
            "origin Russia soil podzolic name Rose stem_color Green sheet_color Red average_size 40",
            "origin England soil soddy_podzolic name Violet stem_color Green sheet_color Yellow average_size 15",
            "origin Russia soil podzolic name Nepenthes stem_color Brown sheet_color Green average_size 40 digestion_in_seconds 654800",
            "origin Russia soil podzolic name Abra stem_color Brown sheet_color Green average_size 180 digestion_in_seconds 6500");

    @Test
    public void shouldReturnListOfMaps() {
        List<Flower> actualList = jaxbParser.parse(fileName);
        Assert.assertEquals(expectedList, actualList);
    }
}
