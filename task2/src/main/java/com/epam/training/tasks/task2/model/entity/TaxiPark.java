package com.epam.training.tasks.task2.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TaxiPark {
    private List<AbstractTaxi> listOfTaxi = new ArrayList<AbstractTaxi>();

    public TaxiPark() {

    }

    public TaxiPark(List<AbstractTaxi> listOfTaxi) {
        this.listOfTaxi = listOfTaxi;
    }

    public List<AbstractTaxi> getListOfTaxi() {
        return listOfTaxi;
    }

    public void setListOfTaxi(List<AbstractTaxi> listOfTaxi) {
        this.listOfTaxi = listOfTaxi;
    }

    public AbstractTaxi getTaxiFromTaxiPark(int index) {
        return listOfTaxi.get(index);
    }

    public void addTaxi(AbstractTaxi abstractTaxi) {
        listOfTaxi.add(abstractTaxi);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        TaxiPark taxiPark = (TaxiPark) o;
        int sizeOfTaxiPark = taxiPark.getListOfTaxi().size();

        if (listOfTaxi.size() != sizeOfTaxiPark) {
            return false;
        }

        for (int i = 0; i < sizeOfTaxiPark; i++) {
            if (listOfTaxi.get(i) != taxiPark.getTaxiFromTaxiPark(i)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = this.hashCode();

        for (int i = 0; i < listOfTaxi.size(); i++) {
            result += prime * listOfTaxi.get(i).hashCode();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        AbstractTaxi tempTaxi;
        String tempToString;

        result.append("Taxi park {\n");

        for (int i = 0; i < listOfTaxi.size(); i++) {
            tempTaxi = listOfTaxi.get(i);
            tempToString = tempTaxi.toString();
            result.append(tempToString);
            result.append("\n");
        }

        result.append("}");

        return new String(result);
    }
}
