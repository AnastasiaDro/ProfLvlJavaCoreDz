package ru.geekbrains.dz2.client;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryWriter {
    BufferedWriter bw;


    public void saveHistory(TextArea textArea) {
        try {
            bw = new BufferedWriter(new FileWriter( "src\\ru\\geekbrains\\dz2\\client\\history.txt" ) );
            bw.write( textArea.getText() );
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}