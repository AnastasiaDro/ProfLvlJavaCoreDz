package ru.geekbrains.dz1.part2fruitTask;

public class FruitAddingException extends Exception {
    private Fruit fruit;

    FruitAddingException (Fruit fruit){
        this.fruit = fruit;
    }

    public String toString() {
        return "FruitAddingException[" + fruit + "]";
    }

}

