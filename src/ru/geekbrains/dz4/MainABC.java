package ru.geekbrains.dz4;

public class MainABC {
    public static void main(String[] args) {
    int counter = 1;
        MyLetterThread aThread = new MyLetterThread( 'A',1, counter);
        MyLetterThread bThread = new MyLetterThread( 'B', 2, counter );
        MyLetterThread cThread = new MyLetterThread( 'C', 3, counter );
    }

}
