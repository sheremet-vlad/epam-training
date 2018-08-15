package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;
import com.epam.training.tasks.task4.model.entity.Composite;
import com.epam.training.tasks.task4.model.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {

    private static final SentenceParser sentenceParser = new SentenceParser();
    private static final String text = "It has survived.";

    @Test
    public void shouldReturnComponentWithSentences() {
        Component actual = sentenceParser.parse(text);
        Component expected = createExpectedComponent();

        Assert.assertEquals(expected, actual);
    }

    private Component createExpectedComponent() {
        Component composite = new Composite();

        Component leaf = new Leaf("It ");
        composite.add(leaf);

        leaf = new Leaf("has ");
        composite.add(leaf);

        leaf = new Leaf("survived.");
        composite.add(leaf);

        return composite;
    }
}
