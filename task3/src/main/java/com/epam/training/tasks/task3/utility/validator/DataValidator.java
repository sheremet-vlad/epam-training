package com.epam.training.tasks.task3.utility.validator;

import com.epam.training.tasks.task3.exception.DataFileIOException;
import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class DataValidator {

    private static final Logger log = Logger.getLogger(DataValidator.class);
    private static final String LANGUAGE = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private static final String LOG_PROPERTIES = "src/main/resources/log4j_properties.properties";

    public boolean validateData(String fileXML, String fileXSD) {

        PropertyConfigurator.configure(LOG_PROPERTIES);

        File schemaLocation = new File(fileXSD);
        boolean isValid = false;

        try {
            SchemaFactory factory = SchemaFactory.newInstance(LANGUAGE);
            Schema schema = factory.newSchema(schemaLocation);

            Validator validator = schema.newValidator();

            Source source = new StreamSource(fileXML);

            validator.validate(source);

            isValid = true;
        } catch (SAXException e ) {
            log.error(e.getMessage(), e);
        } catch (IOException e ) {
            log.error(new DataFileIOException(e.getMessage(), e));
        }

        return isValid;
    }
}
