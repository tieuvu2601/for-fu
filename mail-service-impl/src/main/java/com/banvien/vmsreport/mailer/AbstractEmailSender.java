package com.banvien.vmsreport.mailer;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.ejb.Asynchronous;
import javax.ejb.DuplicateKeyException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by hieu on 11/12/2015.
 */
public abstract class AbstractEmailSender {
    private static Logger logger = Logger.getLogger(AbstractEmailSender.class);

    protected String defaultSender;

    protected String getContent(String templateName, Map<String, Object> model) {
        VelocityContext context = new VelocityContext();
        if(model != null) {
            Set<String> keys = model.keySet();
            for (String key: keys) {
                context.put(key, model.get(key));
            }
        }
        Template template =  Velocity.getTemplate(templateName, "UTF-8");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

    @Asynchronous
    public void sendMessage(List<String> toAddresses,
                            List<String> ccAddresses,
                            List<String> bccAddresses,
                            String subject,
                            String templateName,
                            Map<String,Object> model) {
        sendMessage(toAddresses,ccAddresses,bccAddresses, defaultSender,subject,templateName,model);
    }

    @Asynchronous
    public void sendMessage(List<String> toAddresses,
                            List<String> ccAddresses,
                            List<String> bccAddresses,
                            String sender,
                            String subject,
                            String templateName,
                            Map<String,Object> model) {
        String content = getContent(templateName,model);
        sendMessage(toAddresses,ccAddresses,bccAddresses,sender,subject, content);
    }

    @Asynchronous
    public void sendMessage(List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String subject, String templateName, Map<String, Object> model, String mailType, Integer maxRetry) {
        String content = getContent(templateName,model);
        int count = 0;
        String error;
        do {
            count++;
            error = null;
            try {
                sendMessage(toAddresses,ccAddresses,bccAddresses,defaultSender,subject,content);
            } catch (Exception e) {
                error = e.getMessage();
            }
        } while (count < maxRetry && error != null);

        if (error != null) {
            // log content

        }
    }

    protected void initVelocity() {
        Properties p = new Properties();
        p.put("runtime.log.logsystem.class","org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
        p.put("runtime.log.logsystem.log4j.category","org.apache.velocity");
        p.put("resource.loader","class");
        p.put("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);
    }


    public abstract void sendMessage(final List<String> toAddresses,
                            final List<String> ccAddresses,
                            final List<String> bccAddresses,
                            final String sender,
                            final String subject,
                            final String content);
}
