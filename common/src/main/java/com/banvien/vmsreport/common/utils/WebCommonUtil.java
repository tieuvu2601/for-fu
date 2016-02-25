package com.banvien.vmsreport.common.utils;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: KhanhTran
 * Date: 8/26/15
 * Time: 1:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebCommonUtil {
    private static transient final Logger log = Logger.getLogger(WebCommonUtil.class);

    private static final Pattern EMAIL_P = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

    private static final Pattern ZIP_P = Pattern.compile("\\d{5}(-\\d{4})?");

    private static final Pattern USERNAME_P = Pattern.compile("^[A-Za-z0-9_-]{3,25}");


    public static boolean isValidEmail(String email) {
        Matcher m = EMAIL_P.matcher(email);
        return m.matches();
    }

    public static boolean isValidUsername(String username) {
        Matcher m = USERNAME_P.matcher(username);
        return m.matches();
    }

    public static boolean isValidZip(String zipFile) {
        Matcher m = ZIP_P.matcher(zipFile);
        return m.matches();
    }
}
