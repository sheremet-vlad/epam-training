package com.epam.training.tasks.task3.model.entity;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flower", propOrder = {
        "name",
        "visual_parametr"
})
@XmlSeeAlso({
        CarnivorousFlower.class
})
public class Flower {
    private static final int PRIME = 31;

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected VisualParametr visualParametr;
    @XmlAttribute(name = "origin")
    protected String origin;
    @XmlAttribute(name = "soil")
    protected TypeOfSoil typeOfSoil;


    public Flower() {

    }

    public Flower(String name,
                  TypeOfSoil typeOfSoil,
                  String origin,
                  VisualParametr visualParametr) {
        this.name = name;
        this.origin = origin;
        this.typeOfSoil = typeOfSoil;
        this.visualParametr = visualParametr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfSoil getTypeOfSoil() {
        return typeOfSoil;
    }

    public void setTypeOfSoil(TypeOfSoil typeOfSoil) {
        this.typeOfSoil = typeOfSoil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParametr getVisualParametr() {
        return visualParametr;
    }

    public void setVisualParametr(VisualParametr visualParametr) {
        this.visualParametr = visualParametr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Flower flower = (Flower) o;
        VisualParametr thatVisualParamtr = flower.getVisualParametr();
        String thatName = flower.getName();
        String thatOrigin = flower.getOrigin();
        TypeOfSoil thatTypeOfSoil = flower.getTypeOfSoil();

        return visualParametr.equals(thatVisualParamtr)
                && name.equals(thatName)
                && origin.equals(thatOrigin)
                && typeOfSoil == thatTypeOfSoil;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += name.hashCode() * PRIME;
        result += origin.hashCode() * PRIME;
        result += typeOfSoil.hashCode() * PRIME;
        result += visualParametr.hashCode() * PRIME;
        return result;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "name='" + name + '\'' +
                ", typeOfSoil=" + typeOfSoil +
                ", origin='" + origin + '\'' +
                 visualParametr.toString() +
                '}';
    }
}
