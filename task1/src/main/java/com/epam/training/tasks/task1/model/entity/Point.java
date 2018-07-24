package com.epam.training.tasks.task1.model.entity;

public class Point {
    private int axisX;
    private int axisY;
    private int axisZ;

    public Point(int axisX, int axisY, int axisZ) {
        this.axisX = axisX;
        this.axisY = axisY;
        this.axisZ = axisZ;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public int getAxisZ() {
        return axisZ;
    }

    public void setAxisZ(int axisZ) {
        this.axisZ = axisZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;
        return axisX == point.axisX
                && axisY == point.axisY
                && axisZ == point.axisX;
    }

    @Override
    public int hashCode() {
        return 31 * (axisZ == 0.0 ? 1 : axisZ) + axisY + axisX;
    }

    @Override
    public String toString() {
        return "Point{" +
                " X=" + axisX +
                ", Y=" + axisY +
                ", Z=" + axisZ +
                '}';
    }
}
