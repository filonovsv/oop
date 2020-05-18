package ru.nsu.ccfit.filonov;


import ru.nsu.ccfit.filonov.exceptions.FactoryGetInstanceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TreeMap;

public class Factory {
    private static final String PATH_TO_PROPERTIES = "/factory.properties";

    private final TreeMap<String, Class<ru.nsu.ccfit.filonov.Command>> map = new TreeMap<>();

    public Factory() {
        InputStream fileInputStream = ru.nsu.ccfit.filonov.Factory.class.getResourceAsStream(PATH_TO_PROPERTIES);

        Properties prop = new Properties();
        try {
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : prop.stringPropertyNames()) {
            try {
                map.put(name, (Class<ru.nsu.ccfit.filonov.Command>) Class.forName(prop.getProperty(name)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    ru.nsu.ccfit.filonov.Command getInstance(String command) throws FactoryGetInstanceException {
        try {
            return map.getOrDefault(command, null).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new FactoryGetInstanceException(e.getMessage());
        }
    }

}
