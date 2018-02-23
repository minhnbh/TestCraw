/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.XMLUtilities;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Admin
 */
public class XMLUtils implements Serializable{
    public static void staxCursorParser(List<String> filePath, String xmlFilePath) {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, true);
        factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        factory.setProperty(XMLInputFactory.IS_COALESCING, true);
        //Declare var
        InputStream is = null;
        XMLStreamReader reader = null;
        String productDescription = "";
        String productPrice = "";
    }
}
