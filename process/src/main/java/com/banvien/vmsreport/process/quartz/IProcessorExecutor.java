package com.banvien.vmsreport.process.quartz;

public interface IProcessorExecutor {
    void runTask(IProcessor processor);

    void waitForFinish() throws Exception;

    public void shutDown();
}
