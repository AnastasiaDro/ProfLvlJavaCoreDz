package ru.geekbrains.dz2.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HistoryReader {
    BufferedReader br = null;


    public void readHistory() throws FileNotFoundException {
        try {
        br = new BufferedReader( new FileReader( "src\\ru\\geekbrains\\dz2\\server\\history.txt" ) );
        String str;
        while((str = br.readLine()) != null)
            System.out.println(str);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}