package ru.geekbrains.dz1.part2fruitTask;

public class FruitMain {
    public static void main(String[] args) {

          Apple apple = new Apple();
          Box box = new Box();
          box.putFruit( apple );
          System.out.println(box.getWeight());
    }
}
