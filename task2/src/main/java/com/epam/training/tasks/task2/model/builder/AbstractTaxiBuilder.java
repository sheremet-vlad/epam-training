package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;

import java.util.Map;

public abstract class AbstractTaxiBuilder {
    protected static final String FIELD_PASSENGERS = "passengers";
    protected static final String FIELD_COST_BY_ONE_KM = "costByOneKM";
    protected static final String FIELD_TAXI_COST = "taxiCost";

    public abstract AbstractTaxi create(Map<String, String> objectsFields);

    protected void fill(AbstractTaxi taxi , Map) {

    }
}
