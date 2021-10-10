package com.epam.dataFormats;

import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public interface IXMLCorrectChecker {
    boolean check(File xmlFile, File xsdFile) throws IOException, XMLStreamException, SAXException;
}
