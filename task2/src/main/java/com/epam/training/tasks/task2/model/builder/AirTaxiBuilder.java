package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;
import com.epam.training.tasks.task2.model.entity.TypeOfAirTaxi;
import com.epam.training.tasks.task2.model.factory.TypeOfTaxi;

import java.util.Map;

public class AirTaxiBuilder extends AbstractTaxiBuilder{
    private static final String FIELD_TYPE_OF_AIR_TAXI = "typeOfAirTaxi";
    private static final String PLAIN_TYPE = "PLAIN";

    private TypeOfAirTaxi typeOfAirTaxi;

    public AbstractTaxi create(Map<String, String> objectsFields){
        AirTaxi airTaxi = new AirTaxi();
        assignFieldFromMap(objectsFields);
        setFields(airTaxi);
        return airTaxi;
    }

    protected void assignFieldFromMap(Map<String,String> objectFields) {
        super.assignFieldFromMap(objectFields);

        String tempType = objectFields.get(FIELD_TYPE_OF_AIR_TAXI);
        tempType = tempType.toUpperCase();

        if (tempType.equals(PLAIN_TYPE)) {
            typeOfAirTaxi = TypeOfAirTaxi.Plain;
        }
        else {
            typeOfAirTaxi = TypeOfAirTaxi.Helicopter;
        }
    }

    protected void setFields(AirTaxi airTaxi) {
        super.setFields(airTaxi);
        airTaxi.setTypeOfAirVehicle(typeOfAirTaxi);
    }

}
