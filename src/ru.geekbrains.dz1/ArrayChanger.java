package ru.geekbrains.dz1;


import java.util.ArrayList;
import java.util.Arrays;

public class ArrayChanger <T> {
    //переменная для записи элемента
   // private T[] arr;
    private T container;
    private ArrayList newArrayList = new ArrayList();

    public ArrayChanger () {

    }

    // Задание 1
    // сам метод смены мест ПО ИНДЕКСУ
    public  T[] placeChangerByIndex (T[] arr, int firstIndex, int secondIndex) {
        container = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = container;
        return arr;
    }

    // Задание 2
    // метод преобразования массива в ArrayList
    public ArrayList arrToArrayList(T[] arr) {
        newArrayList.clear();
        for (int i = 0; i < arr.length; i++) {
            newArrayList.add( arr[i]);
        }

        return newArrayList;
    }




}
