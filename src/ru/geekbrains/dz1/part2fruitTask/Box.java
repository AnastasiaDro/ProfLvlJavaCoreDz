package ru.geekbrains.dz1.part2fruitTask;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    ArrayList<T> boxArrayList;
    Float boxWeight;
    boolean comparing;

    //конструктор
    public Box() {
        boxWeight = 0f;
        boxArrayList = new ArrayList<>();
    }

    //положить фрукт в коробку(Сразу изменим её вес)
    public void putFruit(T fruit) throws FruitAddingException {
        try {
            if (!boxArrayList.isEmpty() && boxArrayList.get( 0 ).getClass().getName() != fruit.getClass().getName()) {
                throw new FruitAddingException( fruit );
            } else {
                boxArrayList.add( fruit );
                boxWeight += fruit.getFruitWeight();
            }
        } catch (FruitAddingException e) {
            int pointIndex = fruit.getClass().getName().lastIndexOf( "." ) + 1;
            String fruitName = fruit.getClass().getName().substring( pointIndex );
            System.out.println( "В этой коробке фрукты другого типа! Нельзя положить " + fruitName );
        }
    }

    //положить фрукт в коробку, перегруженный метод на случай "положить сразу несколько фруктов"
    public void putFruit(T fruit, int howMany) throws FruitAddingException {
        try {
            if (!boxArrayList.isEmpty() && boxArrayList.get( 0 ).getClass().getName() != fruit.getClass().getName()) {
                throw new FruitAddingException( fruit );
            } else {
                for (int i = 0; i < howMany; i++) {
                    boxArrayList.add( fruit );
                    boxWeight += fruit.getFruitWeight();
                }
            }
        } catch (FruitAddingException e) {
            int pointIndex = fruit.getClass().getName().lastIndexOf( "." ) + 1;
            String fruitName = fruit.getClass().getName().substring( pointIndex );
            System.out.println( "В этой коробке фрукты другого типа! Нельзя положить " + fruitName );
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


    // метод убрать фрукт из коробки, когда нужно удалить только 1
    public ArrayList<T> removeFruit() {
        //удаляем элемент с последним индексом
        try {
            if (this.boxArrayList.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int index = boxArrayList.size() - 1;
            boxWeight -= this.boxArrayList.get( index ).getFruitWeight();
            this.boxArrayList.remove( index );
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "В коробке нет фруктов!" );
        }
        return this.boxArrayList;
    }

    // перегруженный метод убрать фрукт из коробки, когда нужно удалить несколько
    public ArrayList<T> removeFruit(int howMany) {
        try {
            if (this.boxArrayList.size() < howMany) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int index;
            for (int i = 0; i < howMany; i++) {
                //удаляем элемент с последним индексом
                index = boxArrayList.size() - 1;
                boxWeight -= this.boxArrayList.get( index ).getFruitWeight();
                this.boxArrayList.remove(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "В коробке нет так много фруктов!" );

            System.out.println( boxWeight );
            return boxArrayList;
        }
        return boxArrayList;
    }



    // метод пересыпания фруктов из коробки в коробку
    public ArrayList sendFruit(Box<T> box2, int howMany) throws FruitAddingException, IndexOutOfBoundsException {
        //костыль
        int firstBox2size = box2.boxArrayList.size();

        try {
            if (this.boxArrayList.size()<howMany) {
                throw new IndexOutOfBoundsException();
            } else {
                box2.putFruit( this.boxArrayList.get( 0 ), howMany );
                //результат костыля. Если исключение не вылезло и изменилось число фруктов во второй коробке, то удаляем из первой
                // если нет - не удаляем
                if (box2.boxArrayList.size() > firstBox2size) {
                    this.removeFruit( howMany );
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println( "В коробке нет так много фруктов! Пересыпка отменена" );
        }

        return box2.boxArrayList;}
}
