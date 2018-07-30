package com.epam.training.tasks.task2.model.factory;

import com.epam.training.tasks.task2.model.builder.AbstractTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.AirTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.CargoTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.GroundTaxiBuilder;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;
import com.epam.training.tasks.task2.model.entity.GroundTaxi;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TaxiFactoryTest {
    private final TaxiFactory taxiFactory = new TaxiFactory();
    @Test
    public void shouldReturnObjectAirTaxiBuilder() {

        AbstractTaxiBuilder abstractTaxiBuilder = taxiFactory.factoryMethod(TypeOfTaxi.AIR_TAXI);

        Class expectedClass = AirTaxiBuilder.class;
        Class actualCLass = abstractTaxiBuilder.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }

    @Test
    public void shouldReturnObjectCargoTaxiBuilder() {
        AbstractTaxiBuilder abstractTaxiBuilder = taxiFactory.factoryMethod(TypeOfTaxi.CARGO_TAXI);

        Class expectedClass = CargoTaxiBuilder.class;
        Class actualCLass = abstractTaxiBuilder.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }

    @Test
    public void shouldReturnObjectGroundTaxi() {

        AbstractTaxiBuilder abstractTaxiBuilder = taxiFactory.factoryMethod(TypeOfTaxi.GROUND_TAXI);

        Class expectedClass = GroundTaxiBuilder.class;
        Class actualCLass = abstractTaxiBuilder.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }
}
