package com.cookbook.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by poet on 6/29/16.
 *  java.util.concurrent API provides a class called as Lock, which would basically serialize the control
 *  in order to access the critical resource. It gives method such as park() and unpark().
 * We can do similar things if we can use synchronized keyword and using wait() and notify() notifyAll() methods.
 */

public class MyReentrantLock extends Thread {

    private final static ReentrantLock lock = new ReentrantLock(true);

    public final static void main(String[] args) {
        (new MyReentrantLock()).start();
        (new MyReentrantLock()).start();
        (new MyReentrantLock()).start();
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + System.currentTimeMillis() + " : AAA");
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " : " + System.currentTimeMillis() + " : BBB");
        try {
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " : " + System.currentTimeMillis() + " : " +
                    lock.isLocked()  + " : " + lock.getQueueLength() + " : " + lock.isHeldByCurrentThread());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " : " + System.currentTimeMillis() + " : CCC");
            lock.unlock();
        }
    }



}