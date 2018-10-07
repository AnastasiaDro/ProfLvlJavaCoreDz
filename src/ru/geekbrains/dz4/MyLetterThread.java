package ru.geekbrains.dz4;

public class MyLetterThread implements Runnable {
    char letter;
    int exitNumber;
    //число потоков
    int maxNumber = 3;
    //счётчик номера потока
    int counter;
    Thread t;

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
        printLetter();
    }

    public synchronized int printLetter() {
     //   for (int i = 0; i < 5; i++) {


        print();
        //}
//            System.out.println( letter );
//            if (counter != maxNumber) {
//                counter += 1;
//            } else {
//                counter = 1;
//            }
//            try {
//                while (exitNumber != counter) {
//                    this.wait();
//                }
//            } catch (InterruptedException e) {
//                System.out.println( "ошибка в методе run класса" );
//            }
//        }
//        notifyAll();
       return counter;
    }


    public synchronized void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println( letter );
        }
    }

}