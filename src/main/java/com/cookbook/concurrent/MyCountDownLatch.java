package com.cookbook.concurrent;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by poet on 6/29/16.
 */
public class MyCountDownLatch {

    public final static void main(String[] args) throws Exception {

        // should be called twice
        final CountDownLatch testLatch = new CountDownLatch(5);
        ExecutorService executor = Executors.newFixedThreadPool(1);

        AsyncProcessor processor = new AsyncProcessor(new Observer() {
            // this observer would be the analogue for a listener in your async process
            public void update(Observable o, Object arg) {
                System.out.println("Counting down...");
                testLatch.countDown();
            }
        });

        //submit two tasks to be process, (in my real world example, these were JMS messages)
        executor.submit(processor);
        executor.submit(processor);
        executor.submit(processor);
        executor.submit(processor);
        executor.submit(processor);

        System.out.println("Submitted tasks. Time to wait...");
        long time = System.currentTimeMillis();
        testLatch.await(5000, TimeUnit.MILLISECONDS); // bail after a reasonable time

        long totalTime = System.currentTimeMillis() - time;
        System.out.println("I awaited for " + totalTime + "ms. #count? " + testLatch.getCount());

        executor.shutdown();
    }

    // just a process that takes a random amount of time
    // (up to 2 seconds) and calls its listener
    public static class AsyncProcessor implements Callable<Object> {

        private Observer listener;
        private AsyncProcessor(Observer listener) {
            this.listener = listener;
        }

        public Object call() throws Exception {

            // some processing here which can take all kinds of time...
            int sleepTime = new Random().nextInt(2000);
            System.out.println("Sleeping for " + sleepTime + "ms");
            Thread.sleep(sleepTime);

            listener.update(null, null); // not standard usage, but good for a demo
            return null;
        }
    }

}
