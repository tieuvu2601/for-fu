package com.banvien.vmsreport.mailer;

import com.banvien.vmsreport.mailer.config.MailConfig;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless(name = "EmailSessionBeanEJB")
public class EmailSessionBean implements EmailLocalBean, EmailRemoteBean {
    @EJB(beanName = "AwsEmailSingletonBean")
    private IEmailSingletonBean awsEmailSingletonBean;

    @EJB(beanName = "SmtpEmailSingletonBean")
    private IEmailSingletonBean smtpEmailSingletonBean;

    private IEmailSingletonBean emailBean;

    @PostConstruct
    void init() {
        if ("aws".equalsIgnoreCase(MailConfig.getInstance().getProperty("mail.used.service"))) {
            awsEmailSingletonBean.init();
            emailBean = awsEmailSingletonBean;
        } else {
            smtpEmailSingletonBean.init();
            emailBean = smtpEmailSingletonBean;
        }
    }

    @Override
    public void sendMessage(List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String subject, String templateName, Map<String, Object> model, String mailType, Integer maxRetry) {
        emailBean.sendMessage(toAddresses, ccAddresses, bccAddresses, subject, templateName, model, mailType, maxRetry);
    }

    @Override
    public void sendMessage(List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String subject, String templateName, Map<String, Object> model) {
        emailBean.sendMessage(toAddresses, ccAddresses, bccAddresses, subject, templateName, model);
    }

    @Override
    public void sendMessage(List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String sender, String subject, String templateName, Map<String, Object> model) {
        emailBean.sendMessage(toAddresses, ccAddresses, bccAddresses, sender, subject, templateName, model);
    }

    @Override
    public void sendMessage(List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String sender, String subject, String content) {
        emailBean.sendMessage(toAddresses, ccAddresses, bccAddresses, sender, subject, content);
    }


}
