package ru.geekbrains.dz2.client;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HistoryWriter {
    BufferedWriter bw;

    //ещё новое конструктор
    public HistoryWriter(){
        try{
        this.bw = new BufferedWriter(new FileWriter( "src\\ru\\geekbrains\\dz2\\client\\history.txt" , true) );
    } catch (IOException e) {
            e.printStackTrace();
            System.out.println("файл не найден");
        }
    }

    public void writeHistory(String msg) {
        try {
            bw.write( msg + "\n");
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void closeHistoryWriter(){
        try {
            this.bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}