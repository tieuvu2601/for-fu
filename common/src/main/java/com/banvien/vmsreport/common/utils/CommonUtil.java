package com.banvien.vmsreport.common.utils;

import org.apache.commons.lang.StringUtils;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nguyen Hai Vien
 */
public class CommonUtil {

    private static final Pattern EMAIL_P = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern ZIP_P = Pattern.compile("\\d{5}(-\\d{4})?");
    private static final Pattern USERNAME_P = Pattern.compile("^[A-Za-z0-9_-]{3,25}");
    private static final Pattern ALPHABET = Pattern.compile("[A-Za-z]+");


    public static boolean isValidEmail(String email) {
        Matcher m = EMAIL_P.matcher(email);
        return m.matches();
    }

    public static boolean isValidZip(String email) {
        Matcher m = ZIP_P.matcher(email);
        return m.matches();
    }

    public static boolean isValidUsername(String username) {
        Matcher m = USERNAME_P.matcher(username);
        return m.matches();
    }


    /*
    * get fileName without extension
    */
    public static String getNameWithoutExtension(String fileName) {
        return (fileName.indexOf(".") > 0) ? fileName.substring(0, fileName
                .lastIndexOf(".")) : fileName;
    }

    /*
    * get extension of file
    */
    public static String getExtension(String fileName) {
        return (fileName.indexOf(".") < fileName.length()) ? fileName
                .substring(fileName.lastIndexOf(".") + 1) : "";
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();

    }

    public static String roundUp(Double val, int decimalDigit) {
        if (val == null) {
            return "";
        }
        BigDecimal decimal = new BigDecimal(val);
        decimal = decimal.setScale(decimalDigit, RoundingMode.HALF_UP);
        return decimal.toString();
    }

    /**
     * Trims, removes line breaks, multiple spaces and generally cleans text before processing.
     * @param   input      Text to be transformed
     */
    public static String cleanHtmlTags(String input) {
        try{
            //Remove math expression
            input = input.replaceAll("<span class=\"AM\">`", "");
            input = input.replaceAll("`</span>", " ");
            List<String> res = extractText(new StringReader(input));
            input = StringUtils.join(res, ' ');
        }catch (IOException ex) {

        }

        return input;
    }

    public static List<String> extractText(Reader reader) throws IOException {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        HTMLEditorKit.ParserCallback parserCallback = new HTMLEditorKit.ParserCallback() {
            public void handleText(final char[] data, final int pos) {
                list.add(new String(data));
            }
            public void handleStartTag(HTML.Tag tag, MutableAttributeSet attribute, int pos) {}
            public void handleEndTag(HTML.Tag t, final int pos) {  }
            public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, final int pos) {
                if (t.toString().equalsIgnoreCase("img")) {
                    list.add("###");
                }
            }
            public void handleComment(final char[] data, final int pos) { }
            public void handleError(final String errMsg, final int pos) { }
        };
        parserDelegator.parse(reader, parserCallback, true);
        return list;
    }

    public static String removeDiacritic(String str) {
        String result = Normalizer.normalize(str, Normalizer.Form.NFD);
        result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        result = result.replace('đ', 'd');
        result = result.replace('Đ', 'D');
        result = result.replaceAll("[^a-z A-Z0-9-]", "");
        return result;
    }

    public static String seoURL(String input) {
        String result = Normalizer.normalize(input, Normalizer.Form.NFD);
        result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        result = result.replace('đ', 'd');
        result = result.replace('Đ', 'D');
        result = result.replaceAll("[^a-z A-Z0-9-]", "");
        result = result.replaceAll(" ", "-");
        return result.toLowerCase();
    }



    private static String unaccent(String input) {
        if (StringUtils.isEmpty(input)) {
            return "";
        } else {
            String result = Normalizer.normalize(input, Normalizer.Form.NFD);
            result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            result = result.replace('đ', 'd');
            result = result.replace('Đ', 'D');
            return result;
        }
    }



    public static String formatDate(Date input) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        return sdf.format(input);
    }

    public static File getConfigFile(String fileName) {
        String domainConfigDir = System.getProperty("jboss.domain.config.dir");
        File f;
        if (StringUtils.isNotBlank(domainConfigDir)) {
            f = new File(domainConfigDir + File.separator + fileName);
            if (f.exists()) {
                return f;
            }
        }
        String configDir = System.getProperty("jboss.server.config.dir");
        if (StringUtils.isNotBlank(configDir)) {
            f = new File(configDir + File.separator + fileName);
            if (f.exists()) {
                return f;
            }
        }
        return null;
    }
}
