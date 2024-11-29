package com.evolution.virtualthreads;

import java.util.logging.Logger;

public class SimpleVirtualThread {

    private static final Logger LOGGER = Logger.getLogger(SimpleVirtualThread.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Thread virtualThread = Thread.startVirtualThread(() -> LOGGER.info("Hello from virtual thread: " + Thread.currentThread()));
        virtualThread.join();
    }
}
