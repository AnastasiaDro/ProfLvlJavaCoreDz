package ru.geekbrains.dz4;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.List;

public class MyLetterThread implements Runnable {
    char letter;
    int exitNumber;
    //число потоков
    int maxNumber = 3;
    //счётчик номера потока
    int counter = 1;
    Thread t;

    //конструктор
    public MyLetterThread(char letter, int exitNumber) {
        this.letter = letter;
        this.exitNumber = exitNumber;
        this.t = new Thread( this );
        t.start();
    }


    @Override
    public void run() {
        synchronized (this) {
            try {
                while (exitNumber != counter) {
                    this.wait();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println( letter );
                }

                if (counter != maxNumber) {
                    counter += 1;
                } else {
                    counter = 1;
                }

            }

//        if (exitNumber == counter ) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println( letter );
//            }
//
//                if (counter!= maxNumber) {
//                    counter += 1;
//                } else {
//                    counter = 1;
//                }
//            } else {
//            while (exitNumber != counter) {
//                this.wait();
//            }
//        }
            //}
         catch(InterruptedException e){
            System.out.println( "Поток " + letter + " прерван" );
        }
    }
}

}
