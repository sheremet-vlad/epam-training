package com.epam.training.tasks.task1.utility.creator;

import com.epam.training.tasks.task1.exception.PyramidAppException;
import com.epam.training.tasks.task1.model.entity.Point;
import com.epam.training.tasks.task1.model.entity.Pyramid;
import com.epam.training.tasks.task1.utility.parser.DataParser;
import com.epam.training.tasks.task1.utility.reader.DataReader;
import com.epam.training.tasks.task1.utility.validator.DataValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PyramidCreator {
    private static final Logger log = Logger.getLogger(PyramidCreator.class);
    private static final int INDEX_POINT_BASE_1 = 0;
    private static final int INDEX_POINT_BASE_2 = 1;
    private static final int INDEX_POINT_BASE_3 = 2;
    private static final int INDEX_POINT_BASE_4 = 3;
    private static final int INDEX_TOP_POINT = 4;

    private DataParser dataParser;
    private DataReader dataReader;
    private DataValidator dataValidator;

    public PyramidCreator (DataParser dataParser,
                           DataReader dataReader,
                           DataValidator dataValidator) {
        this.dataParser = dataParser;
        this.dataReader = dataReader;
        this.dataValidator = dataValidator;
    }

    public List<Pyramid> createPyramids(String fileName) {
        dataReader = new DataReader();
        dataValidator = new DataValidator();
        dataParser = new DataParser();

        List<Pyramid> listOfPyramids = new ArrayList<Pyramid>();

        try {
            List<String> linesOfCoordinates;
            List<Point[]> listOfPoints;
            linesOfCoordinates = dataReader.readPoints(fileName);
            linesOfCoordinates = dataValidator.validateData(linesOfCoordinates);
            listOfPoints = dataParser.parseData(linesOfCoordinates);

            for (Point[] pointsArray : listOfPoints) {
                listOfPyramids.add(new Pyramid(pointsArray[INDEX_POINT_BASE_1],
                                                pointsArray[INDEX_POINT_BASE_2],
                                                pointsArray[INDEX_POINT_BASE_3],
                                                pointsArray[INDEX_POINT_BASE_4],
                                                pointsArray[INDEX_TOP_POINT]));
            }

        }
        catch (PyramidAppException e) {
            log.error(e.getMessage(), e);
        }

        return listOfPyramids;
    }

}
