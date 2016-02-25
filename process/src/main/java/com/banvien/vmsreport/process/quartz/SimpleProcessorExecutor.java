package com.banvien.vmsreport.process.quartz;


public class SimpleProcessorExecutor implements IProcessorExecutor {

    public void runTask(IProcessor processor) {
        processor.run();
    }

    public void waitForFinish() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void shutDown() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
