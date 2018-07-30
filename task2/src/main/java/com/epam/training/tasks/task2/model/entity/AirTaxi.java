package com.epam.training.tasks.task2.model.entity;

public class AirTaxi extends AbstractTaxi{

    private TypeOfAirTaxi typeOfAirVehicle;

    public AirTaxi() {
    }

    public AirTaxi(TypeOfAirTaxi typeOfAirTaxi) {
        super();
        this.typeOfAirVehicle = typeOfAirTaxi;
    }


    public AirTaxi(int costByOneKM, int maxPassengerCount, int taxiCost, TypeOfAirTaxi typeOfAirTaxi) {
        super(costByOneKM, maxPassengerCount, taxiCost);
        this.typeOfAirVehicle = typeOfAirTaxi;
    }

    public TypeOfAirTaxi getTypeOfAirVehicle() {
        return typeOfAirVehicle;
    }

    public void setTypeOfAirVehicle(TypeOfAirTaxi typeOfAirVehicle) {
        this.typeOfAirVehicle = typeOfAirVehicle;
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
        AirTaxi airTaxi = (AirTaxi) o;
        return typeOfAirVehicle == airTaxi.typeOfAirVehicle;
    }



    @Override
    public int hashCode() {
        final int PRIME = 31;
        return super.hashCode() + PRIME * typeOfAirVehicle.hashCode();
    }

    @Override
    public String toString() {
        return "AirTaxi{" +
                "costByOneKM=" + getCostByOneKM() +
                ", maxPassengerCount=" + getMaxPassengerCount() +
                ", taxi cost=" + getTaxiCost() +
                ", typeOfAirVehicle=" + typeOfAirVehicle +
                '}';
    }
}
