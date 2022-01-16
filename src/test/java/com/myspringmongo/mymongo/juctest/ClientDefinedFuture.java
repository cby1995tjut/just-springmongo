package com.myspringmongo.mymongo.juctest;

import java.util.concurrent.Callable;

public class ClientDefinedFuture implements Callable, Runnable {
    @Override
    public void run() {

    }

    @Override
    public Object call() throws Exception {
        return "Hello, My Future";
    }
}
