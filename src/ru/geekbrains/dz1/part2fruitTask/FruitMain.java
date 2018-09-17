package ru.geekbrains.dz1.part2fruitTask;

import java.util.ArrayList;

public class FruitMain {
    public static void main(String[] args) throws FruitAddingException {

          Apple apple = new Apple();
          Orange orange = new Orange();
          Box  box = new Box();
          Box box2 = new Box();
         box.putFruit( apple, 2);

          box2.putFruit( orange);
       box.putFruit(apple);


        System.out.println("Вес первой коробки: " + box.getWeight());

     //      box.removeFruit(1);

        System.out.println("пересыпем фрукты");
            box.sendFruit(box,box2, 2 );
        System.out.println("Вес первой коробки: " + box.getWeight());
        System.out.println("Вес второй коробки: " + box2.getWeight());


    }
}
