package ru.geekbrains.dz4;

public class MainABC {
    public static int counter = 1;

    public static void main(String[] args) {
    Methodist m = new Methodist(counter);
        MyLetterThread aThread = new MyLetterThread( 'A',1,  m);
        MyLetterThread bThread = new MyLetterThread( 'B', 2,  m );
        MyLetterThread cThread = new MyLetterThread( 'C', 3,  m );
    }

    public static void setCounter(int counter) {
        MainABC.counter = counter;
    }
}
