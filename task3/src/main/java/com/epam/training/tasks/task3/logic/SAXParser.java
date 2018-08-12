package com.epam.training.tasks.task3.logic;

import com.epam.training.tasks.task3.handler.SAXFLowerHandler;
import com.epam.training.tasks.task3.model.entity.Flower;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import java.io.IOException;
import java.util.List;

import static org.xml.sax.helpers.XMLReaderFactory.createXMLReader;

public class SAXParser  extends AbstractParser{
    private static final Logger log = Logger.getLogger(StaxParser.class);
    private static final String LOG_PROPERTIES = "src/main/resources/log4j_properties.properties";

    public List<Flower> parse(String fileName) {
        PropertyConfigurator.configure(LOG_PROPERTIES);

        SAXFLowerHandler saxfLowerHandler = new SAXFLowerHandler();
        try {
            XMLReader reader = createXMLReader();
            reader.setContentHandler(saxfLowerHandler);
            reader.parse(fileName);
        } catch (IOException ex){
            log.error(ex.getMessage(), ex);
        } catch (SAXException ex){
            log.error(ex.getMessage(), ex);
        }

        return saxfLowerHandler.getFlowers();
    }

}
