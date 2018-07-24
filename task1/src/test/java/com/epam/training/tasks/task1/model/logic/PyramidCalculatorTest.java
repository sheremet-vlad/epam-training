package com.epam.training.tasks.task1.model.logic;

import com.epam.training.tasks.task1.exception.IllegalBasePointsException;
import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.model.entity.Point;
import com.epam.training.tasks.task1.model.entity.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {
    private Pyramid pyramid = new Pyramid(new Point(1,1,1),
                                            new Point(1,9,1),
                                            new Point(9,9,1),
                                            new Point(9,1,1),
                                            new Point(5,5,4));

    private Pyramid notRegularPyramid = new Pyramid(new Point(1,1,1),
                                                    new Point(1,8,1),
                                                    new Point(9,8,1),
                                                    new Point(9,1,1),
                                                    new Point(5,5,4));
    private PyramidCalculator pyramidCalculator = new PyramidCalculator();

    @Test
    public void shouldReturnEighty() throws IllegalBasePointsException {
        double result = pyramidCalculator.calculateSquare(pyramid);
        Assert.assertEquals(result, 80.0, 0.01);
    }

    @Test (expected = IllegalBasePointsException.class)
    public void ShouldReturnIllegalBasePointsExcptionWhenPyramidNotRegular() throws IllegalBasePointsException {
        double result = pyramidCalculator.calculateSquare(notRegularPyramid);
    }

    @Test
    public void shouldReturnSixty() throws IllegalBasePointsException{
        double result = pyramidCalculator.calculateVolume(pyramid);
        Assert.assertEquals(result, 64.0, 0.01);
    }

    @Test
    public void shouldReturnTrueWhenPointsMakeAPyramid () throws NullPointsDataException {
        Point[] points = {new Point(1,1,1),
                            new Point(1,9,1),
                            new Point(9,9,1),
                            new Point(9,1,1),
                            new Point(5,5,4)};
        Assert.assertTrue(pyramidCalculator.isPointsMakePyramid(points));
    }

    @Test (expected = NullPointsDataException.class)
    public void ShouldReturnNullPointsDataExceptionWhenArrayIsEmpty() throws NullPointsDataException {
        boolean result = pyramidCalculator.isPointsMakePyramid(new Point[0]);
    }
}
