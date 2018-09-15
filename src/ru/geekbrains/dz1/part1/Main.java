package ru.geekbrains.dz1.part1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //создадим массив
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] strArr = {"один", "два", "три"};

        //выведем массивы для наглядности
        System.out.println("Массив intArr до вызова методов" + Arrays.asList(intArr));
        System.out.println("Массив strArr до вызова методов" + Arrays.asList(strArr));
        System.out.println();
        //создаём экземпляр класса для проверки методов
        ArrayChanger arrayChanger = new ArrayChanger<>();

        //тестируем методы

        //метод замены элементов местами
        System.out.println("меняем элементы местами");
        arrayChanger.placeChangerByIndex(intArr, 0, 9);
        System.out.println("Массив intArr с поменяными местами элементами" + Arrays.asList(intArr));

        arrayChanger.placeChangerByIndex(strArr,  1,2);
        System.out.println("Массив intSecondArr с поменяными местами элементами" + Arrays.asList(strArr));
        System.out.println();

        //Метод преобразования в ArrayList
        System.out.println("преобразуем оба массива в ArrayList-ы");
        ArrayList myArrayList = arrayChanger.arrToArrayList(intArr);
        System.out.println("ArrayList из массива intArr"+ myArrayList.toString());
        //Покажем, что можем использовать его несколько раз и будут правильные результаты (при каждом вызове происходит очистка newArraylist
        //что позволяет не создавать много ArrayLIst-ов или экземпляров класса PlaceChanger
        ArrayList myArrayList2 = arrayChanger.arrToArrayList(strArr);
        System.out.println("A вот  - из массива strArr" + myArrayList2.toString());

    }
}
