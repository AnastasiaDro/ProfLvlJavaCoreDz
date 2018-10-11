package ru.geekbrains.dz2.client;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HistoryReader {
    BufferedReader br = null;
    ArrayList <String> myArr = new ArrayList(  );

    public String readHistory() throws FileNotFoundException {
        String answer = "";
        int minus = 0;

        try {
        br = new BufferedReader( new FileReader( "src\\ru\\geekbrains\\dz2\\client\\history.txt") );
        String str;

//Чтобы вывести только 100 строк, используем массив

        while((str = br.readLine()) != null)
            myArr.add( str+"\n" );
        if (myArr.size()>100) {
           minus = myArr.size()-100;
            for (int i = 0; i < minus; i++) {
                myArr.remove( 0 );
            }
        }
            StringBuilder builder = new StringBuilder();
            for (String value : myArr) {
                builder.append(value);
            }


            answer += builder.toString();

            answer+="Текущая переписка: \n";
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            answer = "История пуста";
        } finally {
            return answer;
        }

    }

//    public String readHistory() throws FileNotFoundException {
//        String answer = "";
//        try {
//        br = new BufferedReader( new FileReader( "src\\ru\\geekbrains\\dz2\\client\\history.txt") );
//        String str;
//
//        //условие на 100 строк
//
//
//
//        while((str = br.readLine()) != null)
//            answer += str+"\n";
//            answer+="Текущая переписка: \n";
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            answer = "История пуста";
//        } finally {
//            return answer;
//        }
//
//    }


}