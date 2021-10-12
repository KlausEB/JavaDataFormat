package com.epam.dataFormats.impl;

import com.epam.dataFormats.IXMLToJSONConverter;
import org.json.JSONException;
import org.json.XML;

import java.io.*;

public class XMLToJSONConverterImpl implements IXMLToJSONConverter {
    @Override
    public void convert(File XMLResource, File JSONOutput) throws IOException, JSONException {
        try (BufferedReader reader = new BufferedReader(new FileReader(XMLResource));
             PrintWriter writer = new PrintWriter(new FileWriter(JSONOutput))) {
            StringBuilder xmlStringsBuffer = new StringBuilder();
            reader.readLine();
            String readString = reader.readLine();
            readString = readString.replaceAll("\\s[^>]*", "") + '>';
            xmlStringsBuffer.append(readString);
            do {
                readString = reader.readLine();
            } while (readString.charAt(readString.length() - 1) != '>');
            while ((readString = reader.readLine()) != null) {
                xmlStringsBuffer.append(readString.trim());
            }

            String resultBuffering = xmlStringsBuffer.toString();
            writer.println(XML.toJSONObject(resultBuffering));
        }
    }
}
