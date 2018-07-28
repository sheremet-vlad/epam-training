package com.epam.training.tasks.task2.model.entity;


public abstract class AbstractTaxi {
    private int costByOneKM;
    private int maxPassengerCount;
    private int taxiCost;

    private static final int DEFAULT_COST_BY_ONE_KM = 3;
    private static final int DEFAULT_MAX_PASSENGER_COUNT = 4;
    private static final int DEFAULT_TAXI_COST = 1000;

    public AbstractTaxi() {
        costByOneKM = DEFAULT_COST_BY_ONE_KM;
        maxPassengerCount = DEFAULT_MAX_PASSENGER_COUNT;
        taxiCost = DEFAULT_TAXI_COST;
    }

    public AbstractTaxi(int costByOneKM, int maxPassengerCount, int taxiCost) {
        this.costByOneKM = costByOneKM;
        this.maxPassengerCount = maxPassengerCount;
        this.taxiCost = taxiCost;
    }

    public int getCostByOneKM() {
        return costByOneKM;
    }

    public void setCostByOneKM(int costByOneKM) {
        if (costByOneKM <= 0) {
            this.costByOneKM = DEFAULT_COST_BY_ONE_KM;
        }
        else {
            this.costByOneKM = costByOneKM;
        }

    }

    public int getMaxPassengerCount() {
        return maxPassengerCount;
    }

    public void setMaxPassengerCount(int maxPassengerCount) {
        if (maxPassengerCount < 1) {
            this.maxPassengerCount = DEFAULT_MAX_PASSENGER_COUNT;
        }
        else {
            this.maxPassengerCount = maxPassengerCount;
        }

    }

    public int getTaxiCost() {
        return taxiCost;
    }

    public void setTaxiCost(int taxiCost) {
        if (taxiCost < 0) {
            this.taxiCost = DEFAULT_TAXI_COST;
        }
        else {
            this.taxiCost = taxiCost;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;}
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractTaxi abstractTaxi = (AbstractTaxi) o;
        return costByOneKM == abstractTaxi.costByOneKM &&
                maxPassengerCount == abstractTaxi.maxPassengerCount
                && taxiCost == abstractTaxi.getTaxiCost();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;

        return super.hashCode() + PRIME * (costByOneKM + maxPassengerCount + taxiCost);
    }

    @Override
    public String toString() {
        return "AbstractTaxi{" +
                "costByOneKM=" + costByOneKM +
                ", maxPassengerCount=" + maxPassengerCount +
                ", taxiCost=" + taxiCost +
                '}';
    }
}
