package com.manconeg.dynamicProperty;

import java.util.Properties;

public abstract class DynamicProperties {
    static Properties properties;
    public static String getProperty(String property) {
        return properties.getProperty(property);
    }
    public static void setProperties(Properties properties) {
        DynamicProperties.properties = properties;
    }
}
