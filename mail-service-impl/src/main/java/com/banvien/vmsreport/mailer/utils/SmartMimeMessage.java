package com.banvien.vmsreport.mailer.utils;

import javax.activation.FileTypeMap;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * Special subclass of the standard JavaMail {@link MimeMessage}, carrying a
 * default encoding to be used when populating the message and a default Java
 * Activation {@link FileTypeMap} to be used for resolving attachment types.
 *
 *
 * @author Juergen Hoeller
 * @since 1.2
 */
public class SmartMimeMessage extends MimeMessage {

    private final String defaultEncoding;

    private final FileTypeMap defaultFileTypeMap;


    /**
     * Create a new SmartMimeMessage.
     * @param session the JavaMail Session to create the message for
     * @param defaultEncoding the default encoding, or {@code null} if none
     * @param defaultFileTypeMap the default FileTypeMap, or {@code null} if none
     */
    public SmartMimeMessage(Session session, String defaultEncoding, FileTypeMap defaultFileTypeMap) {
        super(session);
        this.defaultEncoding = defaultEncoding;
        this.defaultFileTypeMap = defaultFileTypeMap;
    }


    /**
     * Return the default encoding of this message, or {@code null} if none.
     */
    public final String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    /**
     * Return the default FileTypeMap of this message, or {@code null} if none.
     */
    public final FileTypeMap getDefaultFileTypeMap() {
        return this.defaultFileTypeMap;
    }

}
