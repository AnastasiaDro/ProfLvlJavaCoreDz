package ru.geekbrains.dz5;

import ru.geekbrains.dz1.part1.Main;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
//FIXME
//Автомобиль готов, условие выполнено, уменьшаем счётчик CountDownLatch на 1
        MainClass.setDownStart();
//метод await() блокирует поток, вызвавший его, до тех пор, пока
//счетчик CountDownLatch не станет равен 0
//FIXME

        } catch (Exception e) {
            e.printStackTrace();
        }

//запускает машину по всем сценам (дорога, тоннель, дорога)
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }





    }
}