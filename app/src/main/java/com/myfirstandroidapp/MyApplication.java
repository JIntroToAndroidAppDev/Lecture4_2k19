package com.myfirstandroidapp;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApplication extends Application {
    private ExecutorService threadPool =
            Executors.newSingleThreadExecutor();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
}