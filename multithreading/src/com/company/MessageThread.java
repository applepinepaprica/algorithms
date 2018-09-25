package com.company;

public class MessageThread implements Runnable{
    private int time = 1;

    public MessageThread() {}

    public MessageThread(int time) {
        this.time = time;
    }

    public void run() {
        do {
            System.out.println("Message");
            try {
                Thread.sleep(1000 * time);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }
}
