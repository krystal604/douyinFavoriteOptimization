package com.example.PersistenceStrategy.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

    private static volatile ThreadPoolExecutor threadPool= null;

    private MyThreadPool() {
    }

    public static ThreadPoolExecutor getThreadPool(){
        if (threadPool == null){
            synchronized (MyThreadPool.class){
                if (threadPool == null){
                    threadPool = new ThreadPoolExecutor(2,10,
                            1000, TimeUnit.SECONDS , new ArrayBlockingQueue<>(10));
                }
            }
        }
        return threadPool;
    }
}
