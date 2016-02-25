package com.banvien.vmsreport.mailer;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.*;
import com.banvien.vmsreport.mailer.config.MailConfig;
import org.apache.log4j.Logger;

import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Local(IEmailSingletonBean.class)
public class AwsEmailSingletonBean extends AbstractEmailSender implements IEmailSingletonBean  {
    private static Logger logger = Logger.getLogger(AwsEmailSingletonBean.class);
    private AWSCredentials credentials;
    private AmazonSimpleEmailService ses;
    private Boolean isCopiedBcc=false;
    private String copiedBccEmail = "viennh@banvien.com";


//    @PostConstruct
    @Override
    public void init() {
        String accessKey = MailConfig.getInstance().getProperty("accessKey");
        String secretKey = MailConfig.getInstance().getProperty("secretKey");
        credentials = new BasicAWSCredentials(accessKey,secretKey);
        ses = new AmazonSimpleEmailServiceClient(credentials);
        initVelocity();
        defaultSender =  MailConfig.getInstance().getProperty("defaultSender");
        isCopiedBcc = Boolean.valueOf(MailConfig.getInstance().getProperty("isCopiedBcc","false"));
        copiedBccEmail =  MailConfig.getInstance().getProperty("copiedBccEmail", "viennh@banvien.com");
        logger.info("defaultSender = " + defaultSender);
    }

    @PreDestroy
    void destroy() {
        if (ses != null) {
            ses.shutdown();
        }
    }

    @Override
    @Asynchronous
    public void sendMessage(List<String> toAddresses,
                            List<String> ccAddresses,
                            List<String> bccAddresses,
                            String sender,
                            String subject,
                            String content) {
        if (sender == null) {
            sender = defaultSender;
        }
        boolean needCopy = isCopiedBcc;
        SendEmailRequest request = new SendEmailRequest().withSource(sender);
        Destination destination = new Destination();
        if (toAddresses != null && toAddresses.size() > 0) {
            destination.setToAddresses(toAddresses);
            if (needCopy && toAddresses.contains(copiedBccEmail)) {
                needCopy = false;
            }
        }
        if (ccAddresses != null && ccAddresses.size() > 0) {
            destination.setCcAddresses(ccAddresses);
            if (needCopy && ccAddresses.contains(copiedBccEmail)) {
                needCopy = false;
            }
        }
        if (bccAddresses != null && bccAddresses.size() > 0) {
            destination.setBccAddresses(bccAddresses);
            if (needCopy && bccAddresses.contains(copiedBccEmail)) {
                needCopy = false;
            }
        }
        if (needCopy) {
            if (bccAddresses == null) {
                bccAddresses = new ArrayList<String>();
            }
            bccAddresses.add(copiedBccEmail);
            destination.setBccAddresses(bccAddresses);
        }
        request.setDestination(destination);

        Content subjContent = new Content().withData(subject);
        Message msg = new Message().withSubject(subjContent);
        Content htmlContent = new Content().withData(content);
        Body body = new Body().withHtml(htmlContent);
        msg.setBody(body);
        request.setMessage(msg);
        ses.sendEmail(request);
    }
}
