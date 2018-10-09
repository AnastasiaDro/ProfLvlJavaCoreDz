package ru.geekbrains.dz4;



public class Methodist {
    int maxNumber;
    int counter;

    public Methodist(int counter, int maxNumber) {
        this.counter = counter;
        this.maxNumber = maxNumber;
    }


    synchronized void printLetter(char letter, int exitNumber) {
        for (int i = 0; i < 5; i++) {
            while (exitNumber != counter) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println( "ошибка " + letter );
                }
            }
            System.out.println( letter );

            //увеличиваем счётчик
            if (counter != maxNumber) {
                counter++;
            } else {
                counter = 1;
            }
            MainABC.setCounter( counter );
            //разбудить других
            notifyAll();

        }
    }

}
