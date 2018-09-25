package com.company;

public class ChronoThread implements Runnable {

    Counter c;

    public ChronoThread (Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(c.getI() + " sec");
                synchronized (c) {
                    c.notifyAll();
                }

                Thread.sleep(1000);
                c.incrementI();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
