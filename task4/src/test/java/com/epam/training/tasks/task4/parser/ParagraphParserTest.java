package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;
import com.epam.training.tasks.task4.model.entity.Composite;
import com.epam.training.tasks.task4.model.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class ParagraphParserTest {

    private static final ParagraphParser paragraphTest = new ParagraphParser();
    private static final String text = "It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
            "remaining 35+ essentially 6934-*+ unchanged. It was popularised in the 49756-+*/ \n" +
            "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n" +
            "publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    @Test
    public void shouldReturnComponentWithSentences() {
        Component actual = paragraphTest.parse(text);
        Component expected = createExpectedComponent();

        Assert.assertEquals(expected, actual);
    }

    private Component createExpectedComponent() {
        Component composite = new Composite();

        Component leaf = new Leaf("It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
                "remaining 35+ essentially 6934-*+ unchanged.");
        composite.add(leaf);

        leaf = new Leaf(" It was popularised in the 49756-+*/ \n" +
                "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n" +
                "publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        composite.add(leaf);

        return composite;
    }
}
