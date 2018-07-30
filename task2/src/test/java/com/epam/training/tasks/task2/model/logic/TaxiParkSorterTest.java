package com.epam.training.tasks.task2.model.logic;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.GroundTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaxiParkSorterTest {

    private final TaxiParkSorter taxiParkSorter = new TaxiParkSorter();

    @Test
    public void shouldReturnTaxiParkWithSortedData() {
        TaxiPark taxiPark = new TaxiPark();
        List<AbstractTaxi> expectedList = new ArrayList<>();

        expectedList.add(new GroundTaxi(4,5,500,20));
        expectedList.add(new GroundTaxi(4,5,700,20));
        expectedList.add(new GroundTaxi(4,5,800,20));

        List<AbstractTaxi> entryList = new ArrayList<>();

        entryList.add(new GroundTaxi(4,5,500,20));
        entryList.add(new GroundTaxi(4,5,800,20));
        entryList.add(new GroundTaxi(4,5,700,20));

        taxiPark.setListOfTaxi(entryList);
        taxiPark = taxiParkSorter.sortByTaxiCost(taxiPark);
        List<AbstractTaxi> actualList = taxiPark.getListOfTaxi();

        Assert.assertEquals(expectedList, actualList);
    }
}
