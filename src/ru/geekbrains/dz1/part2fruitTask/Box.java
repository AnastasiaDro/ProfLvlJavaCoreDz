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
        public void putFruit(T fruit) throws FruitAddingException {
            try {
                if (!boxArrayList.isEmpty() && boxArrayList.get( 0 ).getClass().getName() != fruit.getClass().getName()) {
                    throw new FruitAddingException ( fruit );
                } else {
                    boxArrayList.add( fruit );
                    boxWeight += fruit.getFruitWeight();
                }
            } catch (FruitAddingException e) {
                int pointIndex = fruit.getClass().getName().lastIndexOf( "." )+1;
                String fruitName = fruit.getClass().getName().substring( pointIndex );
                System.out.println("В этой коробке фрукты другого типа! Нельзя положить " + fruitName);
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

// Пересыпать фрукты из коробки в коробку.
    public ArrayList <T> fruitShifting(Box box2) {


    return  boxArrayList;
    }




}
