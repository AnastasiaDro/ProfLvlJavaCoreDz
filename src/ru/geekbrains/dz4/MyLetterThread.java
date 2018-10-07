package ru.geekbrains.dz4;

public class MyLetterThread implements Runnable {
    char letter;
    int exitNumber;
    //число потоков
    int maxNumber = 3;
    //счётчик номера потока
    int counter;
    Thread t;

    boolean monitorState = false;

    //конструктор
    public MyLetterThread(char letter, int exitNumber, int counter) {
        this.letter = letter;
        this.counter = counter;
        this.exitNumber = exitNumber;
        this.t = new Thread( this );
        t.start();
    }


    @Override
    public void run() {
        if (monitorState != false)
            notify();
        printLetter();
    }

    public synchronized int printLetter() {

        for (int i = 0; i < 5; i++) {
            if (counter == exitNumber) {
                System.out.println(letter);
                if (counter != maxNumber) {
                    counter = counter + 1;
                } else {
                    counter = 1;
                }

            } else {
                try {
                    monitorState = true;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

       return counter;
    }



}