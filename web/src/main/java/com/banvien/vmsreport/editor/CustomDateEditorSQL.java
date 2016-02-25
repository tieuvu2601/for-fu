package com.banvien.vmsreport.editor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author Vien Nguyen Hai
 * 
 */
public class CustomDateEditorSQL extends PropertyEditorSupport {
	private transient final Log log = LogFactory.getLog(CustomDateEditorSQL.class);
	private String dateFormat = "dd/MM/yyyy";
	public CustomDateEditorSQL(String dateFormat) {
		this.dateFormat = dateFormat;
	}

    public CustomDateEditorSQL(){}

    public void setAsText(String text) throws IllegalArgumentException {
		if (text != null && text.trim().length() > 1) {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			try {
                java.util.Date utilDate = (java.util.Date) format.parse(text);
                Date sqlDate = new Date(utilDate.getTime());
                java.sql.Timestamp timestamp = new Timestamp(sqlDate.getTime());
                setValue(timestamp);
			} catch (Exception e) {
				log.error("Invalid date format [" + dateFormat + "]" + e.getMessage());
			}
		}

	}
}
