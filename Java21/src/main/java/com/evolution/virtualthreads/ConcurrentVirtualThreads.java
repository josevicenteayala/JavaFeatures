package com.evolution.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcurrentVirtualThreads {

    private static final Logger LOGGER = Logger.getLogger(ConcurrentVirtualThreads.class.getName());

    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 1000;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            Thread thread = Thread.startVirtualThread(() -> {
                try {
                    // Simulate a blocking operation
                    Thread.sleep(1000);
                    LOGGER.info("Task completed by: " + Thread.currentThread());
                } catch (InterruptedException e) {
                    LOGGER.log(Level.SEVERE,"Error executing task %{}", e.getMessage());
                }
            });
            threads.add(thread);
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
