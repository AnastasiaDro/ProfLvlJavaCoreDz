package ru.geekbrains.dz1.part2fruitTask;

import java.util.ArrayList;

public class FruitMain {
    public static void main(String[] args) throws FruitAddingException {

          Apple apple = new Apple();
          Orange orange = new Orange();
          Box  box = new Box();
         box.putFruit( apple );

          box.putFruit( orange );
        box.putFruit(apple);


          System.out.println(box.getWeight());
            box.removeFruit(box, 3);



    }
}
