package com.banvien.vmsreport.config;


import java.util.Map;

public class ConnectorConfig extends Config {

    private static final String CONFIG_FILE = "connector.properties";
    private static ConnectorConfig instance;

    public static enum Key {
        useScheduler,
        cronExpressions
    }

    private ConnectorConfig() {
        super(CONFIG_FILE);
    }

    private ConnectorConfig(Map<String, String> properties) {
        super(properties);
    }

    public static ConnectorConfig getInstance() {
        if (instance == null) {
            instance = new ConnectorConfig();
        }
        return instance;
    }

    public static void loadProperties(Map<String, String> properties) {
        if (instance == null) {
            instance = new ConnectorConfig(properties);
        } else {
            instance.clearAndLoadProperties(properties);
        }

    }

    public String getProperty(Key key) {
        return getProperty(key.name());
    }

    public String getProperty(Key key, String defaultValue) {
        return getProperty(key.name(), defaultValue);
    }

    public int getInt(Key key) {
        return Integer.parseInt(getProperty(key.name()));
    }

    public int getInt(Key key, String defaultValue) {
        return Integer.parseInt(getProperty(key.name(), defaultValue));
    }

    public boolean getBoolean(Key key) {
        return Boolean.parseBoolean(getProperty(key.name()));
    }

    public boolean getBoolean(Key key, String defaultValue) {
        return Boolean.parseBoolean(getProperty(key.name(), defaultValue));
    }
}
