package com.banvien.vmsreport.process.quartz;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolProcessorExecutor implements IProcessorExecutor {

    private ThreadPoolExecutor threadPool = null;

    public ThreadPoolProcessorExecutor(int queueSize, int poolSize) {
        threadPool = new ThreadPoolExecutor(poolSize, poolSize,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize));
    }

    public void runTask(IProcessor task) {
        threadPool.submit(task);
    }

    public void shutDown() {
        threadPool.shutdown();
    }

    public void waitForFinish() throws Exception {
        while (threadPool.getActiveCount() > 0) {
            Thread.sleep(1000);
        }
    }
}
