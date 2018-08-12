package com.epam.training.tasks.task3.model.entity;

import com.epam.training.tasks.task3.enumeration.TypeOfSoil;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carnivorous_clower", propOrder = {
        "digestion_in_seconds"
})
public class CarnivorousFlower extends Flower {
    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected int digestionInSeconds;

    private static final int PRIME = 31;

    public CarnivorousFlower() {
        super();
    }

    public CarnivorousFlower(String name,
                             TypeOfSoil typeOfSoil,
                             String origin,
                             VisualParametr visualParametr,
                             int digestionInSeconds) {
        super();
        this.digestionInSeconds = digestionInSeconds;
    }

    public int getDigestionInSeconds() {
        return digestionInSeconds;
    }

    public void setDigestionInSeconds(int digestionInSeconds) {
        this.digestionInSeconds = digestionInSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        CarnivorousFlower carnivorousFlower = (CarnivorousFlower) o;
        return digestionInSeconds == carnivorousFlower.getDigestionInSeconds();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + PRIME * digestionInSeconds;
    }

    @Override
    public String toString() {
        return super.toString() +
                "digestionInSeconds=" + digestionInSeconds +
                '}';
    }
}
