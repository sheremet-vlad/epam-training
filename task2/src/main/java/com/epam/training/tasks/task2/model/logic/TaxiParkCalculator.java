package com.epam.training.tasks.task2.model.logic;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;

import java.util.List;

public class TaxiParkCalculator {

    public int calculateTaxiParCost(TaxiPark taxiPark) {
        List<AbstractTaxi> listOfTaxi = taxiPark.getListOfTaxi();

        int sum = 0;

        for (AbstractTaxi taxi : listOfTaxi) {
            sum += taxi.getTaxiCost();
        }

        return sum;
    }
}
