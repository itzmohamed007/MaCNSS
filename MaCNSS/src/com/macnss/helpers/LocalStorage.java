package com.macnss.helpers;

import java.util.Properties;

// Class used like js localStorage for global share data ressources
public class LocalStorage {
    private static Properties properties = new Properties();

    public static Properties getProperties() {
        return properties;
    }
}
