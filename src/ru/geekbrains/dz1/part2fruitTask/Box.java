package ru.geekbrains.dz1.part2fruitTask;


import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxArrayList = new ArrayList<>();
    Float boxWeight;


    public void putFruit(T fruit) {
        boxArrayList.add(fruit);
    }



}
