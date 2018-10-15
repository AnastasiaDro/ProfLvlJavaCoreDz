package ru.geekbrains.dz5;

public class MainClass {
    public static final int CARS_COUNT = 4;
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

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


//вывести, только когда гонки кончились
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
