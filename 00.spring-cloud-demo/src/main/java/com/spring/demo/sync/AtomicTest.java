package com.spring.demo.sync;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private static final AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ai.incrementAndGet();
                }
                latch.countDown();
            });
        }

        Arrays.stream(threads).forEach(Thread::start);

        latch.await();

        System.out.println(ai);
    }
}
