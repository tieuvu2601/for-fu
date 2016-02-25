package com.banvien.vmsreport.mailer.config;

import com.banvien.vmsreport.common.utils.CommonUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailConfig extends Properties {
    private static MailConfig ourInstance = new MailConfig();

    public static MailConfig getInstance() {
        return ourInstance;
    }

    private MailConfig() {
        try {
            InputStream inStream = new FileInputStream(CommonUtil.getConfigFile("vms/mail.properties"));
            load(inStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found  sadlierconnect-mail.properties" );
        } catch (IOException e) {
            throw new RuntimeException("Could not read the file vportal-mail.properties");
        }
    }

}
