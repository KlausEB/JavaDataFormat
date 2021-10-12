package com.epam.dataFormats.impl;

import com.epam.dataFormats.IJSONParser;
import com.epam.dataFormats.generatedClasses.Gem;
import org.nd4j.shade.jackson.databind.JsonNode;
import org.nd4j.shade.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONParserImpl implements IJSONParser {
    @Override
    public List<Gem> parse(File jsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonFile);
        String jsonString = jsonNode.path("gems").get("gem").toString();
        return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, Gem.class));
    }
}
