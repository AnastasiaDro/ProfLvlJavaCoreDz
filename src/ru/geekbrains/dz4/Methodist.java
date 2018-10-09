package ru.geekbrains.dz4;

import jdk.nashorn.internal.ir.IfNode;

public class Methodist {
    int exitNumber;
    int counter;

    public Methodist(int counter){
        this.counter = counter;
    }


    synchronized void printLetter(char letter, int exitNumber) {
        for (int i = 0; i < 5; i++) {
            while (exitNumber!= counter) {
                try {
                    wait();
                } catch (InterruptedException e){
                    System.out.println("ошибка "+ letter);
                }
            }
            System.out.println(letter);

            //увеличиваем счётчик
            if (counter != 3) {
                 counter++;
            } else {
                counter = 1;
            }
            MainABC.setCounter( counter );
            //разбудить других
            notifyAll();

        }
    }

    public synchronized void setCounter(int counter) {
        this.counter = counter;
    }
}
