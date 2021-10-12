package com.epam.dataFormats;

import com.epam.dataFormats.generatedClasses.Gem;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IJSONParser {
    List<Gem> parse(File jsonParse) throws IOException;
}
