package com.epam.dataFormats;

import com.epam.dataFormats.comparators.GemComparator;
import com.epam.dataFormats.generatedClasses.Gem;
import com.epam.dataFormats.impl.XMLCorrectCheckerImpl;
import com.epam.dataFormats.impl.XMLGemsParserImpl;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) throws XMLStreamException, IOException, SAXException, TransformerException {
        File xmlFile = new File("src/main/resources/gems.xml");
        IXMLGemsParser parser = new XMLGemsParserImpl();
        parser.parseXML(xmlFile);
        List<Gem> list = parser.getGems();
        list.sort(new GemComparator());
        for (Gem e : list) {
            System.out.println(e);
        }

        IXMLCorrectChecker checker = new XMLCorrectCheckerImpl();
        File xsdFile = new File("src/main/resources/schema_gems.xsd");
        System.out.println("The xsl file corresponds to the xsd schema: " + checker.check(xmlFile, xsdFile));

        //transform file with xslt
        File xslFile = new File("src/main/resources/transformer.xsl");
        File outputFile = new File("src/main/resources/postTransformGems.xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(new StreamSource(xslFile));
        transformer.transform(new StreamSource(xmlFile), new StreamResult(outputFile));
    }
}
