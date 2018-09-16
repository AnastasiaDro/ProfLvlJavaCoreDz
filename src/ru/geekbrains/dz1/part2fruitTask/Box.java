package ru.geekbrains.dz1.part2fruitTask;


import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxArrayList = new ArrayList<>();
    Float boxWeight = 0f;
    boolean comparing;


//положить фрукт в коробку (Сразу изменим её вес)
    public void putFruit(T fruit) {
        boxArrayList.add(fruit);
        boxWeight+=fruit.getFruitWeight();
    }

//узнать вес коробки
    public float getWeight() {
        return boxWeight;
    }

//сравнить вес коробок
    public boolean compare(Box box2) {
        if (this.getWeight() == box2.getWeight()) {
            comparing = true;
        } else {
            comparing = false;
        }
        return comparing;
    }



}
