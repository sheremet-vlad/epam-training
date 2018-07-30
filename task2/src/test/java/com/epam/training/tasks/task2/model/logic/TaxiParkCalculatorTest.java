package com.epam.training.tasks.task2.model.logic;

import com.epam.training.tasks.task2.model.entity.GroundTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import org.junit.Assert;
import org.junit.Test;

public class TaxiParkCalculatorTest {
    private final TaxiPark taxiPark = new TaxiPark();
    private final TaxiParkCalculator taxiParkCalcucator = new TaxiParkCalculator();

    @Test
    public void shouldReturnForty() {
        taxiPark.addTaxi(new GroundTaxi(1,23,40,6));
        taxiPark.addTaxi(new GroundTaxi(1,23,40,6));

        int actual = taxiParkCalcucator.calculateTaxiParCost(taxiPark);

        Assert.assertEquals(80,actual);
    }
}
