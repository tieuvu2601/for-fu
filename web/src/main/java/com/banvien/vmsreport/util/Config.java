package com.banvien.vmsreport.util;

import com.banvien.vmsreport.common.utils.CommonUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Copyright (c) by Ban Vien Co., Ltd.
 * User: Vincent Nguyen
 * Date: 4/10/13
 * Time: 3:11 AM
 */
public class Config extends Properties {
    private transient final Logger log = Logger.getLogger(getClass());

    private static Config ourInstance = new Config();
    public static Config getInstance() {
        return ourInstance;
    }

    private Config() {
        super();
        try {
            super.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("vPortal/appconfig.properties"));
        } catch (IOException e) {
            log.fatal("ERROR: can not load config file vPortal/appconfig.properties : "+e);
        }
        File configFile = CommonUtil.getConfigFile("vPortal/appconfig.properties");
        if(configFile != null) {
            try {
                InputStream input = new FileInputStream(configFile);
                Properties serverProperties = new Properties();
                serverProperties.load(input);
                //override the web config
                Set<String> propertyNames = serverProperties.stringPropertyNames();
                for (String key: propertyNames) {
                    this.put(key,serverProperties.get(key));
                }
            } catch (FileNotFoundException e) {
                log.error("Not found vPortal/appconfig.properties file from server configuration. Please check it");
            } catch (IOException e) {
                log.error("Could not load vPortal/appconfig.properties file from server configuration. Please check it");
            }
        }
    }
}
