package ru.geekbrains.dz1.part2fruitTask;


import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxArrayList;
    Float boxWeight;
    boolean comparing;

//конструктор
    public Box  (){
        boxWeight = 0f;
        boxArrayList = new ArrayList<>();
    }



//положить фрукт в коробку (Сразу изменим её вес)
        public void putFruit(T fruit) {

        //здесь можно сделать исключение не тот вес
            if (boxArrayList.isEmpty()) {
                boxArrayList.add( fruit );
                boxWeight += fruit.getFruitWeight();
            } else {

            }
        }
//узнать вес коробки
    public float getWeight() {
        return boxWeight;
    }

//сравнить вес коробок
    public boolean compare(Box<?> box2) {
        if (this.getWeight() == box2.getWeight()) {
            comparing = true;
        } else {
            comparing = false;
        }
        return comparing;
    }



}
