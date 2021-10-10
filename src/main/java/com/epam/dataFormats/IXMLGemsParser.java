package com.epam.dataFormats;

import com.epam.dataFormats.generatedClasses.Gem;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IXMLGemsParser {
    void parseXML(File xmlFile) throws IOException, XMLStreamException;

    List<Gem> getGems();
}
