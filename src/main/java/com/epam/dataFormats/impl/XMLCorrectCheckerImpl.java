package com.epam.dataFormats.impl;

import com.epam.dataFormats.IXMLCorrectChecker;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XMLCorrectCheckerImpl implements IXMLCorrectChecker {
    XMLInputFactory factory = XMLInputFactory.newInstance();

    @Override
    public boolean check(File xmlFile, File xsdFile) throws IOException, XMLStreamException {
        try (FileInputStream fileInputStream = new FileInputStream(xmlFile)) {
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);

            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));
            return true;
        } catch (SAXException e) {
            return false;
        }
    }
}
