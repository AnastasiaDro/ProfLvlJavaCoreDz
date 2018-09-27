package ru.geekbrains.dz2.client;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class ClientMain extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle( "JavaChat" );
        primaryStage.setScene( new Scene(root, 400, 400 ));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
