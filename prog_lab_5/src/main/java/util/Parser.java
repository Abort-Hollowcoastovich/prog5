package util;

import Model.*;
import com.thoughtworks.xstream.XStream;
import java.util.*;

public class Parser {
    Class<? extends LinkedList>  collectionClass;
    Class<Product> collectionElementClass;
    XStream xstream = new XStream();

    public Parser(Class<? extends LinkedList> collectionClass, Class<Product> collectionElementClass) {
        this.collectionClass = collectionClass;
        this.collectionElementClass = collectionElementClass;

        xstream.alias("Collection", collectionClass);
        xstream.processAnnotations(collectionElementClass);
    }

    public String toXml(LinkedList<Product> collection, Class<?>[] classes) {

        xstream.allowTypes(classes);

        return xstream.toXML(collection);
    }

    public LinkedList<Product> fromXML(String xmlString, Class<?>[] classes){
        xstream.allowTypes(classes);
        return (LinkedList<Product>) xstream.fromXML(xmlString);
    }
}
