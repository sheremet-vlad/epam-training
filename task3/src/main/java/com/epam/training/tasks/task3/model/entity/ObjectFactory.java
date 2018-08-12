//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.08.06 at 10:28:22 PM MSK 
//


package com.epam.training.tasks.task3.model.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.flowers package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Flower_QNAME = new QName("http://www.example.com/flowers", "flower");
    private final static QName _CarnivorousFlower_QNAME = new QName("http://www.example.com/flowers", "carnivorousFlower");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.flowers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Flower }
     * 
     */
    public Flower createFlower() {
        return new Flower();
    }

    /**
     * Create an instance of {@link CarnivorousFlower }
     * 
     */
    public CarnivorousFlower createCarnivorousFlower() {
        return new CarnivorousFlower();
    }

    /**
     * Create an instance of {@link Flowers }
     * 
     */
    public Flowers createFlowers() {
        return new Flowers();
    }

    /**
     * Create an instance of {@link VisualParametr }
     * 
     */
    public VisualParametr createVisualParametrs() {
        return new VisualParametr();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Flower }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Flower }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.com/flowers", name = "flower")
    public JAXBElement<Flower> createFlower(Flower value) {
        return new JAXBElement<Flower>(_Flower_QNAME, Flower.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarnivorousFlower }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarnivorousFlower }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.example.com/flowers", name = "carnivorousFlower", substitutionHeadNamespace = "http://www.example.com/flowers", substitutionHeadName = "flower")
    public JAXBElement<CarnivorousFlower> createCarnivorousFlower(CarnivorousFlower value) {
        return new JAXBElement<CarnivorousFlower>(_CarnivorousFlower_QNAME, CarnivorousFlower.class, null, value);
    }

}
