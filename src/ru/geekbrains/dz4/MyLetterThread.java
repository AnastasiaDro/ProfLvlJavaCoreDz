package ru.geekbrains.dz4;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class MyLetterThread implements Runnable {
    char letter;
    int exitNumber;
    Thread t;
//конструктор
public MyLetterThread (char letter, int exitNumber) {
    this.letter  = letter;
    this.exitNumber = exitNumber;
    this.t = new Thread(this  );
    t.start();
}



    @Override
    public void run() {
       // try {
            for (int i = 0; i < 5; i++) {
                System.out.println( letter );
            }
      //  }catch (InterruptedException e)  {
       //     System.out.println("Поток "+ letter + " прерван");
       //     }
      //  }

    }
}
