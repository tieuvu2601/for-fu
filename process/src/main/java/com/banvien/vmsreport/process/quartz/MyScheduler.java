package com.banvien.vmsreport.process.quartz;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class MyScheduler {

    protected final Log LOG = LogFactory.getLog(getClass());

    private Runnable runner;
    private Scheduler scheduler;
    private String cronExpressions;

    private static MyScheduler instance = new MyScheduler();

    private MyScheduler() {

    }

    public static MyScheduler getInstance() {
        return instance;
    }

    public Runnable getRunner() {
        return runner;
    }

    public MyScheduler start(Runnable runner, String cronExpressions) throws SchedulerException {
        shutdown();

        this.runner = runner;
        this.cronExpressions = cronExpressions;

        SchedulerFactory sf = new StdSchedulerFactory();
        scheduler = sf.getScheduler();
        Trigger[]  triggers = getTriggers(this.cronExpressions, "trigger");
        int i = 1;
        for (Trigger trigger : triggers) {
            JobDetail job = getJob(i++);
            Date date = scheduler.scheduleJob(job, trigger);
            LOG.info("job " + job.getJobClass().getName() + " has scheduled to run at " + date.toString());
        }
        scheduler.start();
        return this;
    }

    private Trigger[] getTriggers(String cronExpressions, String trigger_identity_prefix) {
        List<Trigger> triggers = new ArrayList<Trigger>();
        try {
            if(StringUtils.isNotBlank(cronExpressions)) {
                String[] toks = cronExpressions.split(";");
                int i = 1;
                for (String tok : toks) {
                    if(StringUtils.isNotBlank(tok)) {
                        Trigger trigger = newTrigger()
                                .withIdentity(trigger_identity_prefix + i++)
                                .withSchedule(cronSchedule(tok))
                                .build();
                        triggers.add(trigger);
                    }
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException("Cron expressions are invalid", ex);

        }
        return triggers.toArray(new Trigger[triggers.size()]);
    }

    public void shutdown() throws SchedulerException {
        if(scheduler != null) {
            scheduler.shutdown(true);
            scheduler = null;
        }
    }

    public static JobDetail getJob(int index) {
        return newJob(MyJob.class)
                .withIdentity("IntegrationJob_" + index)
                .build();
    }
}
