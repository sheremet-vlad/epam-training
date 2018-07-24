package com.epam.training.tasks.task1.model.entity;

/**
 * @author sheremet-vlad
 *
 * @version 1.0
 */
public class Pyramid {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point forthPoint;
    private Point topPoint;

    public Pyramid(Point firstPoint,
                   Point secondPoint,
                   Point thirdPoint,
                   Point forthPoint,
                   Point topPoint) {
        this.topPoint = topPoint;
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.forthPoint = forthPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    protected void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    protected void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    protected void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public Point getForthPoint() {
        return forthPoint;
    }

    protected void setForthPoint(Point forthPoint) {
        this.forthPoint = forthPoint;
    }

    public Point getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(Point topPoint) {
        this.topPoint = topPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pyramid pyramid = (Pyramid) o;

        return topPoint == pyramid.topPoint
                && firstPoint == pyramid.firstPoint
                && secondPoint == pyramid.secondPoint
                && thirdPoint == pyramid.thirdPoint
                && forthPoint == pyramid.forthPoint;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;

        int result = topPoint.hashCode();
        result += firstPoint.hashCode();
        result += secondPoint.hashCode();
        result += thirdPoint.hashCode();
        result += forthPoint.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", forthPoint=" + forthPoint +
                ", topPoint=" + topPoint +
                '}';
    }
}
