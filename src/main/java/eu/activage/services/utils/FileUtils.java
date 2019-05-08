package eu.activage.services.utils;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static InputStream getResource(String filename) throws IOException {
        return FileUtils.class.getClassLoader().getResource(filename).openStream();
    }
}
