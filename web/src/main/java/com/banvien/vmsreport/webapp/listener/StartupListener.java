package com.banvien.vmsreport.webapp.listener;

import com.banvien.vmsreport.config.ConnectorConfig;
import com.banvien.vmsreport.process.quartz.MyScheduler;
import com.banvien.vmsreport.common.Constants;
import com.banvien.vmsreport.common.utils.CacheUtil;
import com.banvien.vmsreport.context.AppContext;
import com.banvien.vmsreport.core.business.TienDoManagementLocalBean;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;


/**
 * <p>StartupListener class used to initialize and database settings
 * and populate any application-wide drop-downs.
 * <p/>
 * <p>Keep in mind that this listener is executed outside of OpenSessionInViewFilter,
 * so if you're using Hibernate you'll have to explicitly initialize all loaded data at the
 * GenericDao or service level to avoid LazyInitializationException. Hibernate.initialize() works
 * well for doing this.
 *
 */
public class StartupListener implements ServletContextListener {
    private static transient final Logger log = Logger.getLogger(StartupListener.class);


    
    @SuppressWarnings("unchecked")
    public void contextInitialized(ServletContextEvent event) {
        log.debug("Initializing context...");

        CacheUtil.getInstance().clearCache();

        ServletContext context = event.getServletContext();

        // set fields of Constants class in Application Scope
        context.setAttribute(Constants.class.getSimpleName(), createNameToValueMap());
        
        // Orion starts Servlets before Listeners, so check if the config
        // object already exists
        Map<String, Object> config = (HashMap<String, Object>) context.getAttribute(Constants.CONFIG);

        if (config == null) {
            config = new HashMap<String, Object>();
        }

        if (context.getInitParameter(Constants.CSS_THEME) != null) {
            config.put(Constants.CSS_THEME, context.getInitParameter(Constants.CSS_THEME));
        }

        ApplicationContext ctx =
                WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        AppContext.setApplicationContext(ctx);

        startScheduler(ctx);

        context.setAttribute(Constants.CONFIG, config);

        initializeApplicationSetting(context);


    }

    private void testSendSMS() {
        try{
            URL yahoo = new URL("http://10.151.70.55:8123/rest/services/otp/sms?sender=9234&receiver=933656289&message=Oh%20yeah");
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        }catch (Exception e){

        }
    }

    private void startScheduler(final ApplicationContext ctx){
        boolean useSchedule = ConnectorConfig.getInstance().getBoolean(ConnectorConfig.Key.useScheduler, "false");
        if(useSchedule){
            try {
                // stop scheduler
                MyScheduler.getInstance().shutdown();

                // every begin of day
                String timeSchedule =  ConnectorConfig.getInstance().getProperty(ConnectorConfig.Key.cronExpressions);

                MyScheduler.getInstance().start(new Runnable() {
                    public void run() {
                        System.out.println("Run Scheduler");
                        runOneUpdateTinhTrangGoiThau(ctx);
                    }
                }, timeSchedule);
            } catch (SchedulerException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void runOneUpdateTinhTrangGoiThau(ApplicationContext ctx){
        TienDoManagementLocalBean tienDoManagementLocalBean = ctx.getBean(TienDoManagementLocalBean.class);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Date date = new Date(time.getTime());
        int hour = date.getHours();
        System.out.println("hours : "+hour);
        if(Constants.time2UpdateStatus.equals(hour)){
            tienDoManagementLocalBean.updateTinhTrangForGoiThauDangMoiThau();
        }else if(Constants.time2SendSMS.equals(hour)){
            tienDoManagementLocalBean.autoSendMessageForRelativeUser();
        }
    }

    /**
     *
     * @param context
     */
    private void initializeApplicationSetting(ServletContext context) {
        ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Map<String, String> applicationSettingMap = new HashMap<String, String>();
        context.setAttribute("applicationSettingMap", applicationSettingMap);
    }


    /**
     * Shutdown servlet context (currently a no-op method).
     *
     * @param servletContextEvent The servlet context event
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //LogFactory.release(Thread.currentThread().getContextClassLoader());
        //Commented out the above call to avoid warning when SLF4J in classpath.
        //WARN: The method class org.apache.commons.logging.impl.SLF4JLogFactory#release() was invoked.
        //WARN: Please see http://www.slf4j.org/codes.html for an explanation.
    }
    
    /**
     * Puts all public static fields via introspection into the resulting Map.
     * Uses the name of the field as key to reference it's in the Map.
     *
     * @return a Map of field names to field values of
     *         all public static fields of this class
     */
    private static Map createNameToValueMap() {
        Map result = new HashMap();
        Field[] publicFields = Constants.class.getFields();
        for (int i = 0; i < publicFields.length; i++) {
            Field field = publicFields[i];
            String name = field.getName();
            try {
                result.put(name, field.get(null));
            } catch (Exception e) {
                log.fatal(e);
            }
        }

        return result;
    }
}
