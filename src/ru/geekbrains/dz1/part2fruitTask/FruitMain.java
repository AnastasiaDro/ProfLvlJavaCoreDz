package ru.geekbrains.dz1.part2fruitTask;


import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class FruitMain {
    public static void main(String[] args) throws FruitAddingException {

          Apple apple = new Apple();
          Orange orange = new Orange();
          Box  box = new Box();
          Box box2 = new Box();
          Box emptyBox = new Box();
          //можем создавать коробку сразу с предопределенным типом
        Box <Orange> originOrangeBox = new Box<>();

         box.putFruit( apple, 2);


          box2.putFruit( orange);

          box.putFruit(apple);
          //покажем, что нельзя насыпать фрукты другого типа в коробку с фруктами первого
         box2.putFruit( apple );



        System.out.println("Вес первой коробки: " + box.getWeight());

        //другого типа пересыпать фрукты нельзя
        System.out.println("пересыпем фрукты");
        box.sendFruit(box2, 2 );
        System.out.println("Вес первой (яблоки) коробки: " + box.getWeight());
        System.out.println("Вес второй (апельсины) коробки: " + box2.getWeight());
        System.out.println();
        //но можно - в пустую коробку

        System.out.println("Вес пустой коробки: " + emptyBox.getWeight());
        System.out.println("Пересыпем в пустую коробку из первой (яблоки)");
        box.sendFruit( emptyBox,2 );
        System.out.println("Вес первой (яблоки) коробки: " + box.getWeight());
        System.out.println("Вес пустой коробки: " + emptyBox.getWeight());

        System.out.println();
        System.out.println("и можно - в коробку с тем же типом");
        System.out.println("вес originOrangeBox до пересыпания: "+ originOrangeBox.getWeight());
        System.out.println("Вес второй (апельсины) коробки: " + box2.getWeight());
        System.out.println("Пересыпем");
        box2.sendFruit( originOrangeBox,1 );
        System.out.println("вес originOrangeBox ПОСЛЕ пересыпания: "+ originOrangeBox.getWeight());
        System.out.println("Вес второй (апельсины) коробки: " + box2.getWeight());
        System.out.println();

        System.out.println("Сравним вес первой (яблоки, сейчас вес 1) и второй (апельсины) коробок (сейчас вес 0)");
        System.out.println("Результаты сравнения, равен ли вес: "+ box.compare( box2 ));
        System.out.println("удалим яблоко из первой коробки, чтобы вес тоже был равен 0 и сравним еще раз");
        box.removeFruit();
        System.out.println("Вес первой (яблоки) коробки: " + box.getWeight());
        System.out.println("Результаты сравнения, равен ли вес: "+ box.compare( box2 ));

    }
}
