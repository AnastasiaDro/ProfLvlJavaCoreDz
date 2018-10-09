package ru.geekbrains.dz4;

public class MyLetterThread implements Runnable {
    char letter;
    int exitNumber;
    //число потоков
    int maxNumber = 3;
    //счётчик номера потока
    int counter;
    Thread t;
    Methodist m;

    boolean monitorState = false;

    //конструктор
    public MyLetterThread(char letter, int exitNumber, Methodist m) {
        this.letter = letter;
        this.counter = MainABC.counter;
        this.exitNumber = exitNumber;
        this.t = new Thread( this );
        t.start();
        this.m = m;
    }


    @Override
    public void run() {
        //пока: counter!=exitNumber поток спит
           m.printLetter(letter, exitNumber);
            m.prince();
    }


    //блокировка


}