package ru.geekbrains.dz2.server;

import java.sql.*;

public class AuthService {

    private Connection connection;
    private Statement stmt;



    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:ChatUsers.db");
        stmt = connection.createStatement();
    }

    public String getNickByLoginAndPass(String login, String pass){
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM users WHERE login = '" + login + "' AND password = '" + pass + "';");
            //новая строка

            while (rs.next()){
                return rs.getString("nick");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect(){
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
