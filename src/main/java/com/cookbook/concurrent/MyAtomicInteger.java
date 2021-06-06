package com.cookbook.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by poet on 6/30/16.
 */
public class MyAtomicInteger {

    public final static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        ai.compareAndSet(1,1);

    }

}
