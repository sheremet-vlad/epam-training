package com.epam.training.tasks.task2.model.factory;

import com.epam.training.tasks.task2.model.builder.AbstractTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.AirTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.CargoTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.GroundTaxiBuilder;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;

import java.util.Map;

public class TaxiFactory {
    public AbstractTaxi factoryMethod(Map<String, String> objectFields) {
        final String nameOfFieldType = "type";

        String taxiType = objectFields.get(nameOfFieldType);
        taxiType = taxiType.toUpperCase();
        TypeOfTaxi typeOfTaxi = TypeOfTaxi.valueOf(taxiType);

        AbstractTaxi abstractTaxi = null;
        AbstractTaxiBuilder abstractTaxiBuilder;


        switch (typeOfTaxi) {
            case AIR_TAXI: {
                abstractTaxiBuilder = new AirTaxiBuilder();
                abstractTaxi = abstractTaxiBuilder.create(objectFields);
            } break;
            case CARGO_TAXI: {
                abstractTaxiBuilder = new CargoTaxiBuilder();
                abstractTaxi = abstractTaxiBuilder.create(objectFields);
            } break;
            case GROUND_TAXI: {
                abstractTaxiBuilder = new GroundTaxiBuilder();
                abstractTaxi = abstractTaxiBuilder.create(objectFields);
            } break;
        }

        return abstractTaxi;

    }
}
