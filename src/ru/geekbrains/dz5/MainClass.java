package ru.geekbrains.dz5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

//FIXME
//Метод ожидания спадения барьера

    public static void awaitStartOrFinish(CyclicBarrier myBarrier) {
        try {
            myBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static CyclicBarrier getStart(){
        return START;
    }

    public static CyclicBarrier getFinish(){
        return FINISH;
    }




    public static final int CARS_COUNT = 4;
    public static int getCarsCount() {
        return CARS_COUNT;
    }
    //FIXME
 //СДЕЛАТЬ ОДНИМ МЕТОДОМ!!!!! СОздание старта и финиша. Как вариант


    private static final CyclicBarrier START = new CyclicBarrier( CARS_COUNT, new Runnable() {
        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
    }
 );
    private static final CyclicBarrier FINISH = new CyclicBarrier( CARS_COUNT, new Runnable() {
        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
    );
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

//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


//FIXME
//вывести, только когда гонки кончились
//ПОДОЖДАТЬ всех участников
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
