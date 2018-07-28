package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;

import java.util.Map;

public class CargoTaxiBuilder extends GroundTaxiBuilder {

    private static final String FIELD_MAX_CAPACITY = "capacityInKG";

    public AbstractTaxi create(Map<String, String> objectsFields){
        int passengerCount = Integer.parseInt(objectsFields.get(FIELD_PASSENGERS));
        int costByOneKM = Integer.parseInt(objectsFields.get(FIELD_COST_BY_ONE_KM));
        int landingCost = Integer.parseInt(objectsFields.get(FIELD_LANDING_COST));
        int capacityInKG = Integer.parseInt(objectsFields.get(FIELD_MAX_CAPACITY));
        int taxiCost = Integer.parseInt(objectsFields.get(FIELD_TAXI_COST));

        return new CargoTaxi(costByOneKM,passengerCount,taxiCost,landingCost,capacityInKG);
    }
}
