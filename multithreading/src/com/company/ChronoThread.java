package com.company;

public class ChronoThread implements Runnable {
    private int time = 1;
    private int i = 0;

    public ChronoThread() {}

    public ChronoThread(int time) {
        this.time = time;
    }

    public void run() {
        do {
            System.out.println(i + " сек");
            i += time;
            try {
                Thread.sleep(1000 * time);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }
}