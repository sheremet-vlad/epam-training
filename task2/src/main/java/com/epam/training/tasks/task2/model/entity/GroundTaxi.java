package com.epam.training.tasks.task2.model.entity;

public class GroundTaxi extends AbstractTaxi{

    private int landingCost;

    private static final int DEFAULT_LANDING_COST = 10;

    public GroundTaxi() {
        super();
        landingCost = DEFAULT_LANDING_COST;
    }

    public GroundTaxi(int costByOneKM, int maxPassengerCount, int taxiCost, int landingCost) {
        super(costByOneKM,maxPassengerCount, taxiCost);
        this.landingCost = landingCost;
    }

    public int getLandingCost() {
        return landingCost;
    }

    public void setLandingCost(int landingCost) {
        if (landingCost <= 0) {
            this.landingCost = DEFAULT_LANDING_COST;
        }
        else {
            this.landingCost = landingCost;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GroundTaxi that = (GroundTaxi) o;
        return landingCost == that.landingCost;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return super.hashCode() + PRIME * landingCost;
    }

    @Override
    public String toString() {
        return "GroundTaxi{" +
                " passenger count=" + getMaxPassengerCount() +
                " cost by one km=" + getCostByOneKM() +
                " taxi cost=" + getTaxiCost() +
                " landingCost=" + landingCost +
                '}';
    }
}
