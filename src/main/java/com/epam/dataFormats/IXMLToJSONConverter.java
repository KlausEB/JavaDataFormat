package com.epam.dataFormats;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;

public interface IXMLToJSONConverter {
    void convert(File XMLResource, File JSONOutput) throws IOException, JSONException;
}
