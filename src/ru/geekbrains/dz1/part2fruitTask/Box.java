package ru.geekbrains.dz1.part2fruitTask;


import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxArrayList = new ArrayList<>();
    Float boxWeight;


//положить фрукт в коробку (Сразу изменим её вес)
    public void putFruit(T fruit) {
        boxArrayList.add(fruit);
        boxWeight+=fruit.getFruitWeight();
    }

//узнать вес коробки
    public float getWeight() {
        return boxWeight;
    }





}
