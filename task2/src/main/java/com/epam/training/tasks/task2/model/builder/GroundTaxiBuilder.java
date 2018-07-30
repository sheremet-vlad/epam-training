package com.epam.training.tasks.task2.model.builder;

import com.epam.training.tasks.task2.model.entity.AbstractTaxi;
import com.epam.training.tasks.task2.model.entity.GroundTaxi;

import java.util.Map;

public class GroundTaxiBuilder extends AbstractTaxiBuilder {

    protected static final String FIELD_LANDING_COST = "landingCost";

    private int landingCost;

    public AbstractTaxi create(Map<String, String> objectsFields){
        GroundTaxi groundTaxi = new GroundTaxi();

        assignFieldFromMap(objectsFields);
        setFields(groundTaxi);

        return groundTaxi;
    }

    protected void assignFieldFromMap(Map<String, String> objectsFields) {
        super.assignFieldFromMap(objectsFields);

        landingCost = Integer.parseInt(objectsFields.get(FIELD_LANDING_COST));
    }

    protected void setFields(GroundTaxi groundTaxi) {
        super.setFields(groundTaxi);
        groundTaxi.setLandingCost(landingCost);
    }
}
