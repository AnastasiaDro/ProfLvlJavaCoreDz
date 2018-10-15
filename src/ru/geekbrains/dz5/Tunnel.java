package ru.geekbrains.dz5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

//FIXME
    //благодаря Семафору в тоннель может заехать не более половины участников
    int tunnelCapacity = MainClass.getCarsCount()/2;
    Semaphore TUNNEL_SEMAPHORE = new Semaphore( tunnelCapacity );
    private final boolean[] TUNNEL_PLACES = new boolean[tunnelCapacity];
//FIXME

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override


    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
 //FIXME
 //Ставим тут семафор
                TUNNEL_SEMAPHORE.acquire();
                int tunnelPlace = -1;
 //ищем свободное место в тоннеле
                synchronized (TUNNEL_PLACES) {
                    for (int i = 0; i < TUNNEL_PLACES.length; i++) {
                        if(!TUNNEL_PLACES[i]){
                            TUNNEL_PLACES[i] = true;
                            tunnelPlace = i;
                            System.out.println(c.getName() + " начал этап: " + description);
                            break;
                        }
                    }
                }



  //              System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
 //Освобождаем тоннель
             synchronized (TUNNEL_PLACES) {
                 TUNNEL_PLACES[tunnelPlace] = false;
             }
//освобождаем семафор
            TUNNEL_SEMAPHORE.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}