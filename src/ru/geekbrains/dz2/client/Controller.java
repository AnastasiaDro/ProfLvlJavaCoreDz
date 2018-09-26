package ru.geekbrains.dz2.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    TextArea textArea;
    @FXML
    TextField msgField;
    @FXML
    HBox msgPanel;
    @FXML
    HBox authPanel;
    @FXML
    TextField loginField;
    @FXML
    PasswordField passField;


    public void sendAuthMsg(ActionEvent actionEvent) {
    }

    public void sendMsg(ActionEvent actionEvent) {
    }
}
