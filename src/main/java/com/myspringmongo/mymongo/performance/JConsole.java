package com.myspringmongo.mymongo.performance;

import java.util.ArrayList;
import java.util.List;

public class JConsole extends Thread {

    private final List<PerformanceBean> beans = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5 * 1000);
                System.out.println("hahahaha");

                for (int i = 0; i < 10; i++) {
                    beans.add(new PerformanceBean("aaaa", 123));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread current = new JConsole();
        current.start();
    }

    //command jconsol
}
