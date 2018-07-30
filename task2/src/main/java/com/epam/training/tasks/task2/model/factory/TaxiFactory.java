package com.epam.training.tasks.task2.model.factory;

import com.epam.training.tasks.task2.model.builder.AbstractTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.AirTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.CargoTaxiBuilder;
import com.epam.training.tasks.task2.model.builder.GroundTaxiBuilder;
import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.AirTaxi;

import java.util.Map;

public class TaxiFactory {

    public AbstractTaxiBuilder factoryMethod(TypeOfTaxi typeOfTaxi) {

        AbstractTaxiBuilder abstractTaxiBuilder = null;

        switch (typeOfTaxi) {
            case AIR_TAXI: {
                abstractTaxiBuilder = new AirTaxiBuilder();
            } break;
            case CARGO_TAXI: {
                abstractTaxiBuilder = new CargoTaxiBuilder();
            } break;
            case GROUND_TAXI: {
                abstractTaxiBuilder = new GroundTaxiBuilder();
            } break;
        }

        return abstractTaxiBuilder;
    }
}
