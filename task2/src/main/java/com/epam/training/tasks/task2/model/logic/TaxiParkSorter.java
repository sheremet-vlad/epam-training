package com.epam.training.tasks.task2.model.logic;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.TaxiPark;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiParkSorter {
    public TaxiPark sortByTaxiCost(TaxiPark taxiPark) {
        List<AbstractTaxi> listOfTaxi = taxiPark.getListOfTaxi();
        System.out.println(listOfTaxi);

        listOfTaxi.sort(new Comparator<AbstractTaxi>() {
            public int compare(AbstractTaxi o1, AbstractTaxi o2) {
                int costO1 = o1.getTaxiCost();
                int costO2 = o2.getTaxiCost();

                int passengersO1 = o1.getMaxPassengerCount();
                int passengersO2 = o2.getMaxPassengerCount();

                if (costO1  == costO2){
                    return compareValue(passengersO1, passengersO2);
                }

                return compareValue(costO1, costO2);
            }
        });
        taxiPark.setListOfTaxi(listOfTaxi);

        return taxiPark;
    }

    private int compareValue(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        } else {
            return -1;
        }
    }
}
