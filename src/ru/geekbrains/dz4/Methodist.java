package ru.geekbrains.dz4;

import jdk.nashorn.internal.ir.IfNode;

public class Methodist {
    int exitNumber;
    int counter;


    synchronized int printLetter(char letter) {
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
                counter=1;
            }
            //notifyAll();
        }
       return counter;
    }

    public void prince() {
        notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
