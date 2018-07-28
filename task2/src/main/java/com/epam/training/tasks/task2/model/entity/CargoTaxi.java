package com.epam.training.tasks.task2.model.entity;


public class CargoTaxi extends GroundTaxi{

    private int maxCapacityInKG;

    private static final int DEFAULT_MAX_CAPACITY_IN_KG = 1000;

    public CargoTaxi() {
        super();
        maxCapacityInKG = DEFAULT_MAX_CAPACITY_IN_KG;
    }

    public CargoTaxi(int costByOneKM, int maxPassengerCount, int taxiCost, int landingCost, int maxCapacityInKG) {
        super(costByOneKM, maxPassengerCount, landingCost, taxiCost);
        this.maxCapacityInKG = maxCapacityInKG;
    }

    public int getMaxCapacityInKG() {
        return maxCapacityInKG;
    }

    public void setMaxCapacityInKG(int maxCapacityInKG) {
        if (maxCapacityInKG <= 0) {
            this.maxCapacityInKG = DEFAULT_MAX_CAPACITY_IN_KG;
        }
        else {
            this.maxCapacityInKG = maxCapacityInKG;
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
        if (!super.equals(o)){
            return false;
        }
        CargoTaxi cargoTaxi = (CargoTaxi) o;
        return maxCapacityInKG == cargoTaxi.maxCapacityInKG;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return super.hashCode() + PRIME * maxCapacityInKG;
    }

    @Override
    public String toString() {
        return "CargoTaxi{" +
                " passenger count" + getMaxPassengerCount() +
                " cost by one km" + getCostByOneKM() +
                " landingCost=" + getLandingCost() +
                " taxiCost=" + getTaxiCost() +
                " maxCapacityInKG=" + maxCapacityInKG +
                '}';
    }
}
