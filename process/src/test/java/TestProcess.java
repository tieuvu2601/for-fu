import com.banvien.vmsreport.config.ConnectorConfig;
import com.banvien.vmsreport.process.quartz.MyScheduler;
import org.quartz.SchedulerException;

public class TestProcess {


    public TestProcess(){

    }

    private void runOne(){
        System.out.println("Run One");
    }

    public void run(){
        Runtime.getRuntime().addShutdownHook(new ThreadHook());
        startScheduler();
    }

    private void startScheduler(){
        try {
            // every 5 mins
            String timeSchedule =  ConnectorConfig.getInstance().getProperty(ConnectorConfig.Key.cronExpressions);

            MyScheduler.getInstance().start(new Runnable() {
                public void run() {
                    System.out.println("Run Scheduler");
                    runOne();
                }
            }, timeSchedule);
        } catch (SchedulerException ex) {
            throw new RuntimeException(ex);
        }
    }


    private class ThreadHook extends Thread {

        @Override
        public void run() {
            try {
                MyScheduler.getInstance().shutdown();
            } catch (SchedulerException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
