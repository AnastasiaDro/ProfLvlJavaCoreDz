package ru.geekbrains.dz2.client;

import java.io.*;

public class HistoryReader {
    BufferedReader br = null;


    public String readHistory() throws FileNotFoundException {
        String answer = "";
        try {
        br = new BufferedReader( new FileReader( "src\\ru\\geekbrains\\dz2\\client\\history.txt") );
        String str;

        //условие на 100 строк




        while((str = br.readLine()) != null)
            answer += str+"\n";
            answer+="Текущая переписка: \n";
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            answer = "История пуста";
        } finally {
            return answer;
        }

    }


}