package com.epam.training.tasks.task4.parser;

import com.epam.training.tasks.task4.model.entity.Component;
import com.epam.training.tasks.task4.model.entity.Composite;
import com.epam.training.tasks.task4.model.entity.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class TextParserTest {
    private final static TextParser textParser = new TextParser();
    private final static String text = "It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
            "remaining 35+ essentially 6934-*+ unchanged. It was popularised in the 49756-+*/ \n" +
            "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n" +
            "publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
            "\n" +
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. \n" +
            "The point of using lpsum is that it has a more-or-less normal \n" +
            "distribution of letters, as opposed to using (Content here), content here', making it look like readable English. \n" +
            "\n" +
            "It is a 978i++34--*/+ established fact that a reader will be of a page when looking at its layout.";

    @Test
    public void shouldReturnCompositeOfParagraphs() {
        Component actual = textParser.parse(text);
        Component expected = createExpectedComponent();

        Assert.assertEquals(expected, actual);
    }

    private Component createExpectedComponent() {
        Component component = new Composite();
        Component leaf = new Leaf("It has survived - not only j— centuries, but also the leap into 13i--+ electronic typesetting, \n" +
                "remaining 35+ essentially 6934-*+ unchanged. It was popularised in the 49756-+*/ \n" +
                "with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop \n" +
                "publishing software like Aldus PageMaker including versions of Lorem Ipsum. ");
        component.add(leaf);

        leaf = new Leaf("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. \n" +
                "The point of using lpsum is that it has a more-or-less normal \n" +
                "distribution of letters, as opposed to using (Content here), content here', making it look like readable English. ");
        component.add(leaf);

        leaf = new Leaf("It is a 978i++34--*/+ established fact that a reader will be of a page when looking at its layout.");
        component.add(leaf);

        return component;
    }
}
