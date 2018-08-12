package com.epam.training.tasks.task3.logic;
import com.epam.training.tasks.task3.model.entity.Flower;
import com.epam.training.tasks.task3.model.entity.Flowers;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

public class JaxbParser extends AbstractParser{

    @Override
    public List<Flower> parse(String fileName) {
        JAXBContext jc = null;
        Flowers flowers = null;
        try {
            jc = JAXBContext.newInstance("com.example.flowers");
            Unmarshaller um = jc.createUnmarshaller();
            String schemaName = "src/test/resources/flowers.xsd";
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
// создание схемы и перадача ее демарашаллизатору
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            flowers =
                    (Flowers) um.unmarshal(new File("src/test/resources/flowers.xml"));
            System.out.println(flowers);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return flowers.getFlowers();
    }

}
