package ru.geekbrains.dz4;

public class MainABC {
    public static void main(String[] args) {
    int counter = 1;
    Methodist m = new Methodist();
        MyLetterThread aThread = new MyLetterThread( 'A',1, counter, m);
        MyLetterThread bThread = new MyLetterThread( 'B', 2, counter, m );
        MyLetterThread cThread = new MyLetterThread( 'C', 3, counter, m );
    }

}
