package ru.geekbrains.dz5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {


    //благодаря Семафору в тоннель может заехать не более половины участников
    Semaphore tonnelSemaphore = new Semaphore( MainClass.getCarsCount()/2 );
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override


    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
 //Ставим тут семафор

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
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