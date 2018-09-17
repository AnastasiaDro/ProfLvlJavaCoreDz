package ru.geekbrains.dz1.part2fruitTask;

public class FruitAddingException extends Exception {
    private Fruit fruit;

    FruitAddingException (Fruit fruit){
        this.fruit = fruit;
    }

    public String toString() {
        return "FruitAddngException[" + fruit + "]";
    }

}


//здесь можно сделать исключение не тот фрукт
//            if (boxArrayList.isEmpty()) {
//                    boxArrayList.add( fruit );
//                    boxWeight += fruit.getFruitWeight();
//                    } else {
//
//                    }