package com.banvien.vmsreport.process.quartz;

import java.util.concurrent.Callable;

public interface IProcessor extends Callable<Boolean> {
    public void run();
}
