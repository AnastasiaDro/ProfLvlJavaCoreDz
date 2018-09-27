package ru.geekbrains.dz2.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import ru.geekbrains.dz2.server.AuthService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    final String SERVER_IP = "localhost";
    final int SERVER_PORT = 8189;

    private boolean authhorized;

    public void setAuthhorized(boolean authhorized) {
        this.authhorized = authhorized;
        if (authhorized){
            msgPanel.setVisible(true);
            msgPanel.setManaged(true);
            authPanel.setVisible(false);
            authPanel.setManaged(false);
        } else {
            msgPanel.setVisible(false);
            msgPanel.setManaged(false);
            authPanel.setVisible(true);
            authPanel.setManaged(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthhorized(false);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String s = in.readUTF();
                            if (s.equals("/authok")){
                                setAuthhorized(true);
                                break;
                            }
                            textArea.appendText(s + "\n");
                        }

                        while (true) {
                            String s = in.readUTF();
                            textArea.appendText(s + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        setAuthhorized(false);
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t.setDaemon(true);
            t.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAuthMsg(){
        // "/auth login pass"
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
            loginField.clear();
            passField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(msgField.getText());
            msgField.clear();
            msgField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод смены ника
    public void changeNick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        msgField.clear();
//        textArea.setText("Введите желаемый ник в поле ввода \n" );
//        msgField.requestFocus();

        //окно ввода нового ника
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Смена ника");
        dialog.setHeaderText("Введите желаемый ник");
        dialog.setContentText("Желаемый ник:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newNick -> System.out.println("Новый ник: " + newNick));

        //коннект к базе
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:ChatUsers.db");
        PreparedStatement stmtChanging = connection.prepareStatement( "UPDATE users SET nick = '" + result + "'  WHERE Nick = ?" );
        //
//изменить данные таблицы
        ResultSet rs = stmtChanging.executeQuery();


       //дисконнект
        try {
            stmtChanging.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showAlert(String msg){
        Platform.runLater( new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Возникли проблемы");
                alert.setHeaderText(null);
                alert.setContentText(msg);
                alert.showAndWait();
            }
        });
    }


}
