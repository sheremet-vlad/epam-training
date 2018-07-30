package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.CargoTaxi;
import java.util.Map;

public class CargoTaxiBuilder extends GroundTaxiBuilder {

    private static final String FIELD_MAX_CAPACITY = "capacityInKG";

    private int capacityInKG;

    public AbstractTaxi create(Map<String, String> objectsFields){
        CargoTaxi cargoTaxi = new CargoTaxi();

        assignFieldFromMap(objectsFields);
        setFields(cargoTaxi);

        return cargoTaxi;
    }

    protected void assignFieldFromMap(Map<String, String> objectsFields) {
        super.assignFieldFromMap(objectsFields);

        capacityInKG = Integer.parseInt(objectsFields.get(FIELD_MAX_CAPACITY));
    }

    protected void setFields(CargoTaxi cargoTaxi) {
        super.setFields(cargoTaxi);

        cargoTaxi.setMaxCapacityInKG(capacityInKG);
    }
}
