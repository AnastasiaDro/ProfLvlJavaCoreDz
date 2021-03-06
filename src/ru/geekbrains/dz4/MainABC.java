package ru.geekbrains.dz4;

public class MainABC {
    //переключатель, используемый для запуска потока с таким же порядковым номером (exitNumber)
    public static int counter = 1;
    //максимальный порядковый номер потока (равен количеству потоков)
    static int maxNumber = 3;

    public static void main(String[] args) {
    Methodist m = new Methodist(counter, maxNumber);
        MyLetterThread aThread = new MyLetterThread( 'A',1,  m);
        MyLetterThread bThread = new MyLetterThread( 'B', 2,  m );
        MyLetterThread cThread = new MyLetterThread( 'C', 3,  m );
    }

    public static void setCounter(int counter) {
        MainABC.counter = counter;
    }
}
