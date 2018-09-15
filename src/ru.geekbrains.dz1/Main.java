package ru.geekbrains.dz1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //создадим массив
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] intSecondArr = {8, 8, 8};

        //создаём экземпляр класса для проверки методов
        PlaceChanger placeChanger = new PlaceChanger<>();

        //тестируем методы
        ArrayList myArrayList = placeChanger.arrToArrayList(intArr);
        System.out.println(myArrayList.toString());
        ArrayList myArrayList2 = placeChanger.arrToArrayList(intSecondArr);
        System.out.println(myArrayList2.toString());





    }
}
