package com.hgs.movapp.executor;

import android.support.annotation.NonNull;


import com.hgs.domain.interface_adapters.ThreadExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    JobExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new JobExecutor.JobThreadFactory());
    }

    public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private int counter;

        private JobThreadFactory() {
            this.counter = 0;
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_" + this.counter++);
        }
    }
}