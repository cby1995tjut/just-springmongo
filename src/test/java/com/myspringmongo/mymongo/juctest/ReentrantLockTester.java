package com.myspringmongo.mymongo.juctest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTester {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

    }

//    final void lock() {
//        if (compareAndSetState(0, 1))
//            setExclusiveOwnerThread(Thread.currentThread());
//        else
//            acquire(1);
//    }
//
//    protected final boolean compareAndSetState(int expect, int update) {
//        // See below for intrinsics setup to support this
//        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
//    }
//
//    protected final boolean tryAcquire(int acquires) {
//        return nonfairTryAcquire(acquires);
//    }
//
//    final boolean nonfairTryAcquire(int acquires) {
//        final Thread current = Thread.currentThread();
//        int c = getState();
//        if (c == 0) {
//            if (compareAndSetState(0, acquires)) {
//                setExclusiveOwnerThread(current);
//                return true;
//            }
//        }
//        else if (current == getExclusiveOwnerThread()) {
//            int nextc = c + acquires;
//            if (nextc < 0) // overflow
//                throw new Error("Maximum lock count exceeded");
//            setState(nextc);
//            return true;
//        }
//        return false;
//    }
}
