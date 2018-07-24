package com.epam.training.tasks.task1.utility.reader;

import com.epam.training.tasks.task1.exception.FileOfPointsNotFoundException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger log = Logger.getLogger(DataReader.class);

    public List<String> readPoints(String fileName) throws FileOfPointsNotFoundException {
        List<String> linesOfPoints = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line;
            line = reader.readLine();

            while (line != null) {
                linesOfPoints.add(line);
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            throw new FileOfPointsNotFoundException(e.getMessage(), e);
        }
        finally {
            if (reader != null){
                try {
                    reader.close();
                }
                catch (IOException e){
                    log.error(e.getMessage(), e);
                }
            }
        }

        return linesOfPoints;
    }
}
