package com.epam.training.tasks.task2.model.factory;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;
import com.epam.training.tasks.task2.model.entity.GroundTaxi;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TaxiFactoryTest {
    @Test
    public void shouldReturnObjectAirTaxi() {
        TaxiFactory taxiFactory = new TaxiFactory();
        Map<String, String> entryMap = new HashMap<String, String>();
        entryMap.put("type", "Air_taxi");
        entryMap.put("costByOneKM", "40");
        entryMap.put("passengers", "9");
        entryMap.put("taxiCost", "5000");
        entryMap.put("typeOfAirTaxi", "plain");

        AbstractTaxi abstractTaxi = taxiFactory.factoryMethod(entryMap);

        Class expectedClass = AirTaxi.class;
        Class actualCLass = abstractTaxi.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }

    @Test
    public void shouldReturnObjectCargoTaxi() {
        TaxiFactory taxiFactory = new TaxiFactory();
        Map<String, String> entryMap = new HashMap<String, String>();
        entryMap.put("type", "Cargo_Taxi");
        entryMap.put("costByOneKM", "12");
        entryMap.put("passengers", "2");
        entryMap.put("taxiCost", "5000");
        entryMap.put("landingCost", "8");
        entryMap.put("capacityInKG", "800");

        AbstractTaxi abstractTaxi = taxiFactory.factoryMethod(entryMap);

        Class expectedClass = CargoTaxi.class;
        Class actualCLass = abstractTaxi.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }

    @Test
    public void shouldReturnObjectGroundTaxi() {
        TaxiFactory taxiFactory = new TaxiFactory();
        Map<String, String> entryMap = new HashMap<String, String>();
        entryMap.put("type", "Ground_Taxi");
        entryMap.put("costByOneKM", "12");
        entryMap.put("taxiCost", "5000");
        entryMap.put("passengers", "2");
        entryMap.put("landingCost", "8");

        AbstractTaxi abstractTaxi = taxiFactory.factoryMethod(entryMap);

        Class expectedClass = GroundTaxi.class;
        Class actualCLass = abstractTaxi.getClass();

        Assert.assertEquals(actualCLass, expectedClass);
    }
}
