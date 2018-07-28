package com.epam.training.tasks.task2.utility.reader;

import com.epam.training.tasks.task2.exception.DataFileNotFoundException;
import com.epam.training.tasks.task2.exception.DataFileReadingException;
import com.epam.training.tasks.task2.exception.TaxiParkAppException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger log = Logger.getLogger(DataReader.class);

    public List<String> readData(String fileName) throws TaxiParkAppException {
        
        List<String> readedStrings = new ArrayList<String>();
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String tempString = reader.readLine();
            
            while (tempString != null) {
                readedStrings.add(tempString);
                tempString = reader.readLine();
            }
        }
        catch (FileNotFoundException e){
            throw new DataFileNotFoundException(e.getMessage(), e);
        }
        catch (IOException e) {
            throw new DataFileReadingException(e.getMessage(), e);
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e){
                    log.error(e.getMessage(), e);
                }
            }
        }

        return readedStrings;
    }
}
