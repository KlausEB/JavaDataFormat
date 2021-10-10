package com.epam.dataFormats.impl;

import com.epam.dataFormats.IXMLGemsParser;
import com.epam.dataFormats.generatedClasses.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLGemsParserImpl implements IXMLGemsParser {
    private final List<Gem> gems = new ArrayList<>();
    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    @Override
    public void parseXML(File xmlFile) throws IOException, XMLStreamException {
        try (FileInputStream fileInputStream = new FileInputStream(xmlFile)) {
            XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (name.equals("gem")) {
                        gems.add(buildGem(reader));
                    }
                }
            }
        }
    }

    public Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new Gem();
        gem.setValue(Integer.parseInt(reader.getAttributeValue(null, "value")));
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                String name = reader.getLocalName();
                switch (name.toUpperCase()) {
                    case "NAME":
                        reader.next();
                        gem.setName(reader.getText());
                        break;
                    case "PRECIOUSNESS":
                        reader.next();
                        gem.setPreciousness(Preciousness.valueOf(reader.getText()));
                        break;
                    case "ORIGIN":
                        reader.next();
                        gem.setOrigin(reader.getText());
                        break;
                    case "VISUAL":
                        reader.next();
                        gem.setVisual(buildVisual(reader));
                        break;
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                String name = reader.getLocalName();
                if (name.equals("gem")) {
                    return gem;
                }
            }
        }
        return gem;
    }

    public Visual buildVisual(XMLStreamReader reader) throws XMLStreamException {
        Visual visual = new Visual();
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                String name = reader.getLocalName();
                switch (name.toUpperCase()) {
                    case "COLOR":
                        reader.next();
                        visual.setColor(Color.valueOf(reader.getText()));
                        break;
                    case "TRANSPARENCY":
                        reader.next();
                        visual.setTransparency(Integer.parseInt(reader.getText()));
                        break;
                    case "CUTTINGMETHOD":
                        reader.next();
                        visual.setCuttingMethod(CuttingMethod.valueOf(reader.getText()));
                        break;
                }
            } else if (type == XMLStreamConstants.END_ELEMENT) {
                String name = reader.getLocalName();
                if (name.equals("visual")) {
                    return visual;
                }
            }
        }
        return visual;
    }

    @Override
    public List<Gem> getGems() {
        return gems;
    }
}
