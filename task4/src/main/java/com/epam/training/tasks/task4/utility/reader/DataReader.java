package com.epam.training.tasks.task4.utility.reader;

import com.epam.training.tasks.task4.exception.DataFileIOException;
import com.epam.training.tasks.task4.exception.DataFileIsEmptyException;
import org.apache.log4j.Logger;

import java.io.*;

public class DataReader {
    private static final Logger log = Logger.getLogger(DataReader.class);

    public String readData(String fileName) throws DataFileIOException {
        BufferedReader reader = null;
        StringBuilder text = new StringBuilder();

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line = reader.readLine();

            while (line != null) {
                text.append(line);
                line = reader.readLine();
                if (line != null) {
                    text.append("\n");
                }
            }
        }
        catch (IOException e) {
            throw new DataFileIOException(e.getMessage(), e);
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    log.error(e);
                }
            }
        }

        StringBuilder emptyString = new StringBuilder();
        if (text.equals(emptyString)) {
            throw new DataFileIsEmptyException("data file is empty");
        }

        return new String(text);
    }
}
