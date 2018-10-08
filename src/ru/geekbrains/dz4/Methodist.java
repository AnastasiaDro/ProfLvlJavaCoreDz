package ru.geekbrains.dz4;

public class Methodist {

    int counter;


    synchronized int printLetter(char letter) {
        for (int i = 0; i < 5; i++) {
            System.out.println(letter);
        }


       return counter;
    }


}
