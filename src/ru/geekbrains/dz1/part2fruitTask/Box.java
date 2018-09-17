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

// метод убрать фрукт из коробки
        public ArrayList <T> removeFruit(int howMany){
        try {
            int index = boxArrayList.size()-1;
            for (int i = 0; i < howMany; i++) {
                //удаляем элемент с последним индексом
                boxWeight -= this.boxArrayList.get(index).getFruitWeight();
                this.boxArrayList.remove(index - i);
            }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("В коробке нет так много фруктов!");

            System.out.println(boxWeight);
                    return boxArrayList;
                }
        return boxArrayList;
        }
// перегрузим метод убрать фрукт из коробки, когда нужно удалить только 1
        public ArrayList <T> removeFruit(){
        //удаляем элемент с последним индексом
            try {
                int index = boxArrayList.size()-1;
                boxWeight -= this.boxArrayList.get(index).getFruitWeight();
                this.boxArrayList.remove(index - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("В коробке нет фруктов!");
            }
    return this.boxArrayList;
    }

// метод пересыпания фруктов из коробки в коробку
    //не могу передать в метод переменную, которая его вызвала
    public ArrayList sendFruit(Box <T> box, Box <T> box2, int howMany) throws FruitAddingException {
       // System.out.println(box.boxArrayList.get(0).getClass().getName());
        for (int i = 0; i < howMany; i++) {
        box2.putFruit(box.boxArrayList.get(0));
        }
        box.removeFruit(howMany);
        return box2.boxArrayList;
    }

}
