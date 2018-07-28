package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.GroundTaxi;

import java.util.Map;

public class GroundTaxiBuilder extends AbstractTaxiBuilder {

    protected static final String FIELD_LANDING_COST = "landingCost";

    public AbstractTaxi create(Map<String, String> objectsFields){
        int passengerCount = Integer.parseInt(objectsFields.get(FIELD_PASSENGERS));
        int costByOneKM = Integer.parseInt(objectsFields.get(FIELD_COST_BY_ONE_KM));
        int landingCost = Integer.parseInt(objectsFields.get(FIELD_LANDING_COST));
        int taxiCost = Integer.parseInt(objectsFields.get(FIELD_TAXI_COST));

        return new GroundTaxi(costByOneKM,passengerCount,taxiCost,landingCost);
    }
}
