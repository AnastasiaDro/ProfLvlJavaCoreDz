package ru.geekbrains.dz5;

import java.util.concurrent.CountDownLatch;

public class MainClass {


//Метод уменьшаем счётчик латча и замораживаем, пока не станет старт wait
    public static void setDownStart() {
        try {
            START.countDown();
            START.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setDownFinish() {
        try {
            FINISH.countDown();
            FINISH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static final int CARS_COUNT = 4;
    //FIXME
    private static final CountDownLatch START = new CountDownLatch( CARS_COUNT+1 );
    private static final CountDownLatch FINISH = new CountDownLatch( 8 );
    //FIXME


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
 //Трасса
 //Дороги и тоннель усыпляют поток (машину) на какое-то время, зависимое от скорости
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
 //Участники гонок
        Car[] cars = new Car[CARS_COUNT];
// В классе Car - implements Runnable. Одна машина = один поток

//Задаём каждой машине скорость
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

 //запускаем машину
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }



//FIXME
//Вывести сообщение только когда все участники готовы
//ПОДОЖДАТЬ всех участников
//Дать объявление о начале

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//Ещё раз уменьшаем наш START
        START.countDown();

//FIXME
//вывести, только когда гонки кончились
//ПОДОЖДАТЬ всех участников
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
