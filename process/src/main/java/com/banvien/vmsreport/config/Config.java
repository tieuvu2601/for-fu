package com.banvien.vmsreport.config;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Config {
    private Properties props;

    public Config(String file) {
        try {
            addProperties(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Config(Map<String, String> properties) {
        clearAndLoadProperties(properties);
    }

    private static Properties loadProperties(String fileName) throws IOException {
        String configDir = System.getProperty("config.dir");
        InputStream input = null;
        if(StringUtils.isNotBlank(configDir)) {
            input = new FileInputStream(new File(configDir + File.separator + fileName));
        } else {
            input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        }

        Properties props = new Properties();
        props.load(input);
        return props;
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public void addProperties(String file) throws IOException {
        Properties newProps = loadProperties(file);
        if(props == null) {
            props = newProps;
        } else {
            for(String key : newProps.stringPropertyNames()) {
                props.setProperty(key, props.getProperty(key));
            }
        }
    }

    public void clearAndLoadProperties(Map<String, String> properties) {
        if(props != null) {
            props.clear();
        } else {
            props = new Properties();
        }
        for (String key : properties.keySet()) {
            props.setProperty(key, properties.get(key));
        }
    }

}
