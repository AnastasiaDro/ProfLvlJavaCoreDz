package ru.geekbrains.dz1;


public class PlaceChanger <T> {
    private T[] arr;
    //переменная для записи элемента
    private T container;

    public PlaceChanger (T[] arr) {
        this.arr = arr;
    }

    //сам метод смены мест ПО ИНДЕКСУ
    public T[] placeChangerByIndex (int firstIndex, int secondIndex) {
        container = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = container;
        return arr;
    }



}
