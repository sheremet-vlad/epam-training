package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.TypeOfAirTaxi;

import java.util.Map;

public class AirTaxiBuilder extends AbstractTaxiBuilder{
    private static final String FIELD_TYPE_OF_AIR_TAXI = "typeOfAirTaxi";
    private static final String PLAIN_TYPE = "PLAIN";

    public AbstractTaxi create(Map<String, String> objectsFields){
        int passengerCount = Integer.parseInt(objectsFields.get(FIELD_PASSENGERS));
        int costByOneKM = Integer.parseInt(objectsFields.get(FIELD_COST_BY_ONE_KM));
        int taxiCost = Integer.parseInt(objectsFields.get(FIELD_TAXI_COST));

        String tempType = objectsFields.get(FIELD_TYPE_OF_AIR_TAXI);
        tempType = tempType.toUpperCase();
        TypeOfAirTaxi typeOfAirTaxi;

        if (tempType.equals(PLAIN_TYPE)) {
            typeOfAirTaxi = TypeOfAirTaxi.Plain;
        }
        else {
            typeOfAirTaxi = TypeOfAirTaxi.Helicopter;
        }

        return new AirTaxi(costByOneKM,passengerCount,taxiCost,typeOfAirTaxi);
    }




}
