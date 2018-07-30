package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;

import java.util.Map;

public abstract class AbstractTaxiBuilder {
    private static final String FIELD_PASSENGERS = "passengers";
    private static final String FIELD_COST_BY_ONE_KM = "costByOneKM";
    private static final String FIELD_TAXI_COST = "taxiCost";

    private int passengerCount;
    private int taxiCost;
    private int costByOneKM;

    public abstract AbstractTaxi create(Map<String, String> objectsFields);

    protected void assignFieldFromMap(Map<String, String> objectsFields) {
        int passengerCount = Integer.parseInt(objectsFields.get(FIELD_PASSENGERS));
        int costByOneKM = Integer.parseInt(objectsFields.get(FIELD_COST_BY_ONE_KM));
        int taxiCost = Integer.parseInt(objectsFields.get(FIELD_TAXI_COST));
    }

    protected void setFields(AbstractTaxi abstractTaxi) {
        abstractTaxi.setCostByOneKM(costByOneKM);
        abstractTaxi.setTaxiCost(taxiCost);
        abstractTaxi.setMaxPassengerCount(passengerCount);
    }
}
