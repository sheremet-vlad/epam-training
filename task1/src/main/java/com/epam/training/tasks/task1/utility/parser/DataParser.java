package com.epam.training.tasks.task1.utility.parser;

import com.epam.training.tasks.task1.exception.NullPointsDataException;
import com.epam.training.tasks.task1.model.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static final String SPLIT_REGEX_TO_LINE = ";";
    private static final String SPLIT_REGEX_TO_POINT = " ";
    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;
    private static final int INDEX_Z = 2;
    private static final int POINT_COUNT_IN_PYRAMID = 5;

    public List<Point[]> parseData(List<String> linesOfPoints) throws NullPointsDataException{
        if (linesOfPoints == null) {
            throw new NullPointsDataException("List of point is empty");
        }

        String[] pyramidPoints;
        String[] pointCoordinates;
        List<Point[]> pointsList = new ArrayList<Point[]>();
        Point[] points;
        Point temp;

        int coordinateX;
        int coordinateY;
        int coordinateZ;

        for (int i = 0; i < linesOfPoints.size(); i++) {
            pyramidPoints = linesOfPoints.get(i).split(SPLIT_REGEX_TO_LINE);
            points = new Point[POINT_COUNT_IN_PYRAMID];

            for (int j = 0; j < pyramidPoints.length; j++) {
                pointCoordinates = pyramidPoints[i].trim().split(SPLIT_REGEX_TO_POINT);

                coordinateX = Integer.parseInt(pointCoordinates[INDEX_X]);
                coordinateY = Integer.parseInt(pointCoordinates[INDEX_Y]);
                coordinateZ = Integer.parseInt(pointCoordinates[INDEX_Z]);

                temp = new Point(coordinateX,
                                 coordinateY,
                                 coordinateZ);
                points[j] = temp;
            }

            pointsList.add(points);
        }

        return pointsList;
    }

}
