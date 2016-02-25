package com.banvien.vmsreport.mailer;

import javax.ejb.Asynchronous;
import java.util.List;
import java.util.Map;

/**
 * Created by hieu on 11/12/2015.
 */
public interface IEmailBean {
    @Asynchronous
    public void sendMessage(List<String> toAddresses,
                            List<String> ccAddresses,
                            List<String> bccAddresses,
                            String subject,
                            String templateName,
                            Map<String, Object> model,
                            String mailType,
                            Integer maxRetry);
    @Asynchronous
    public void sendMessage(List<String> toAddresses,
                            List<String> ccAddresses,
                            List<String> bccAddresses,
                            String subject,
                            String templateName,
                            Map<String, Object> model);
    @Asynchronous
    public void sendMessage(final List<String> toAddresses,
                            final List<String> ccAddresses,
                            final List<String> bccAddresses,
                            final String sender,
                            final String subject,
                            final String templateName,
                            final Map<String, Object> model);
    @Asynchronous
    public void sendMessage(final List<String> toAddresses,
                            final List<String> ccAddresses,
                            final List<String> bccAddresses,
                            final String sender,
                            final String subject,
                            final String content);
}
