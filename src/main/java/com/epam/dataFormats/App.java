package com.epam.dataFormats;

import com.epam.dataFormats.comparators.GemComparator;
import com.epam.dataFormats.generatedClasses.Gem;
import com.epam.dataFormats.impl.JSONParserImpl;
import com.epam.dataFormats.impl.XMLCorrectCheckerImpl;
import com.epam.dataFormats.impl.XMLGemsParserImpl;
import com.epam.dataFormats.impl.XMLToJSONConverterImpl;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) {
        try {
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

            File JSONOutputFile = new File("src/main/resources/gems.json");
            IXMLToJSONConverter converter = new XMLToJSONConverterImpl();
            converter.convert(xmlFile, JSONOutputFile);
            System.out.println("Convert is done");

            IJSONParser jsonParser = new JSONParserImpl();
            List<Gem> gems = jsonParser.parse(JSONOutputFile);
            System.out.println(gems);
        } catch (IOException | TransformerException | XMLStreamException | SAXException | JSONException e) {
            e.printStackTrace();
        }
    }
}
