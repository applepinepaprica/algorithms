package com.company;

/* Напишите программу, которая каждую секунду отображает на экране данные о времени,
   прошедшем от начала сессии, а другой ее поток выводит сообщение каждые пять секунд.
   Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком,
   Отсчитывающим время.
   Не внося изменений в код потока-"хронометра", добавьте еще один поток,
   который выводит на экран другое сообщение каждые семь секунд. */

public class Main {

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(new ChronoThread(c));
        t1.start();
        Thread t2 = new Thread(new MessageThread(c, 5, "Every 5 sec"));
        t2.start();
        Thread t3 = new Thread(new MessageThread(c, 7, "Every 7 sec"));
        t3.start();
    }
}
