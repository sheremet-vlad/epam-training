package com.epam.training.tasks.task3.model.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visual_parametr", propOrder = {
        "stem_color",
        "sheet_color",
        "average_size"
})
public class VisualParametr {

    private static final int PRIME = 31;

    @XmlElement(required = true)
    protected String stemColor;
    @XmlElement(required = true)
    protected String sheetColor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected int averageSize;

    public VisualParametr() {
    }

    public VisualParametr(String stemColor,
                          String sheetColor,
                          int averageSize) {
        this.averageSize = averageSize;
        this.sheetColor = sheetColor;
        this.stemColor = stemColor;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getSheetColor() {
        return sheetColor;
    }

    public void setSheetColor(String sheetColor) {
        this.sheetColor = sheetColor;
    }

    public int getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(int averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VisualParametr that = (VisualParametr) o;

        return averageSize == that.averageSize
               && sheetColor.equals(that.getSheetColor())
               && stemColor.equals(that.getStemColor());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result += PRIME * averageSize;
        result += PRIME * stemColor.hashCode();
        result += PRIME * sheetColor.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "stemColor='" + stemColor + '\'' +
                ", sheetColor='" + sheetColor + '\'' +
                ", averageSize=" + averageSize +
                '}';
    }
}
