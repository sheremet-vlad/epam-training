package com.epam.training.tasks.task1.model.logic;

import com.epam.training.tasks.task1.exception.IllegalBasePointsException;
import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.model.entity.Point;
import com.epam.training.tasks.task1.model.entity.Pyramid;

public class PyramidCalculator {
    private static final double DIVIDER = 2.0;
    private static final double CONST_FOR_VOLUME = 3.0;
    private static final int INDEX_OF_TOP_POINT = 4;

    public double calculateSquare(Pyramid pyramid) throws IllegalBasePointsException{
        Point point1 = pyramid.getFirstPoint();
        Point point2 = pyramid.getSecondPoint();
        Point point3 = pyramid.getThirdPoint();
        Point point4 = pyramid.getForthPoint();
        Point topPoint = pyramid.getTopPoint();

        if (isNotRegularPyramid(point1,point2,point3,point4)) {
            throw new IllegalBasePointsException("Pyramid is not regular");
        }

        return calculateBaseSquare(point1, point2) +
                calculateTrianglesSquare(point1, point2, topPoint);
    }

    public double calculateVolume(Pyramid pyramid) throws IllegalBasePointsException{
        Point point1 = pyramid.getFirstPoint();
        Point point2 = pyramid.getSecondPoint();
        Point point3 = pyramid.getThirdPoint();
        Point point4 = pyramid.getForthPoint();
        Point topPoint = pyramid.getTopPoint();

        if (isNotRegularPyramid(point1,point2,point3,point4)) {
            throw new IllegalBasePointsException("Pyramid is not regular");
        }

        int pyramidaHeight = topPoint.getAxisZ() - point1.getAxisZ();

        return (calculateBaseSquare(point1,point2) * pyramidaHeight) / CONST_FOR_VOLUME;
    }

    public boolean isPointsMakePyramid(Point[] listOfPoint) throws NullPointsDataException {
        if (listOfPoint.length == 0) {
            throw new NullPointsDataException("List of point is empty");
        }

        int baseAxisZ;
        baseAxisZ = listOfPoint[0].getAxisY();

        for (int i = 1; i < listOfPoint.length ; i++) {
            if (!(baseAxisZ == listOfPoint[i].getAxisZ() || i == INDEX_OF_TOP_POINT)) {
                return false;
            }
        }

        return true;
    }


    public double calculateTrianglesSquare(Point point1, Point point2, Point point3){
        double identifier = calculateMatrixIdentifier(point1, point2, point3);
        return Math.abs(identifier) / DIVIDER;
    }

    private int calculateMatrixIdentifier(Point point1, Point point2, Point point3) {
        int mainDiagonal = 0;
        int secondaryDiagonal = 0;

        int point1AxisX = point1.getAxisX();
        int point1AxisY = point1.getAxisY();
        int point2AxisX = point2.getAxisX();
        int point2AxisY = point2.getAxisY();
        int point3AxisX = point3.getAxisX();
        int point3AxisY = point3.getAxisY();

        // x1-x3 x2-x3
        // y1-y3 y2-y3
        mainDiagonal = point1AxisX - point3AxisX;
        mainDiagonal *= point2AxisY - point3AxisY;
        secondaryDiagonal = point2AxisX - point3AxisX;
        secondaryDiagonal *= point1AxisY - point3AxisY;
        return mainDiagonal - secondaryDiagonal;
    }

    private double calculateBaseSquare(Point point1, Point point2) {
        double lineLength = calculateLineLength(point1, point2);

        return lineLength * lineLength;
    }

    private static double calculateLineLength(Point point1, Point point2){
        int axisY1 = point1.getAxisX();
        int axisX1 = point1.getAxisY();
        int axisX2 = point2.getAxisX();
        int axisY2 = point2.getAxisY();
        return Math.sqrt((axisX2 - axisX1) * (axisX2 - axisX1)
                            + (axisY2  - axisY1) * (axisY2 - axisY1));
    }

    public static boolean isNotRegularPyramid(Point point1, Point point2, Point point3, Point point4) {

        double side1 = calculateLineLength(point1, point2);
        double side2 = calculateLineLength(point2, point3);
        double side3 = calculateLineLength(point3, point4);
        double side4 = calculateLineLength(point4, point1);

        return  !(side1 == side2 && side2 == side3 && side3 == side4);
    }
}
