package com.evolution.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualThreadExecutorExample {

    private static final Logger LOGGER = Logger.getLogger(VirtualThreadExecutorExample.class.getName());

    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                executor.submit(() -> {
                    try {
                        // Simulate a task
                        Thread.sleep(1000);
                        LOGGER.info("Task executed by: " + Thread.currentThread());
                    } catch (InterruptedException e) {
                        LOGGER.log(Level.SEVERE,"Error executing task %{}", e.getMessage());
                    }
                });
            }

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }
    }
}
