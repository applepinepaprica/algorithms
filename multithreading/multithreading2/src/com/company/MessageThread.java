package com.company;

import com.sun.jmx.snmp.SnmpUnknownSecModelException;

public class MessageThread implements Runnable {

    Counter c;
    int time;
    String message;

    public MessageThread (Counter c, int time, String message) {
        this.c = c;
        this.time = time;
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (c) {
                try {
                    c.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c.getI() % time == 0) {
                    System.out.println(message);
                }
            }
        }
    }
}
