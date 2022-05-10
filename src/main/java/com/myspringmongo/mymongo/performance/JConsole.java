package com.myspringmongo.mymongo.performance;

public class JConsole extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5 * 1000);
                System.out.println("hahahaha");
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
