package ru.geekbrains.dz1;


import java.util.ArrayList;
import java.util.Arrays;

public class PlaceChanger <T> {
    //переменная для записи элемента
    private T[] arr;
    private T container;
    private ArrayList newArrayList = new ArrayList();

    public PlaceChanger (T[] arr) {
        this.arr = arr;
    }

    // Задание 1
    // сам метод смены мест ПО ИНДЕКСУ
    public  T[] placeChangerByIndex (int firstIndex, int secondIndex) {
        container = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = container;
        return arr;
    }

    // Задание 2
    // метод преобразования массива в ArrayList
    public ArrayList arrToArrayList(T[] arr) {
        newArrayList.add(Arrays.asList(arr));
        return newArrayList;
    }


}
