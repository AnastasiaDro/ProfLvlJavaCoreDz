package ru.geekbrains.dz2.server;

import ru.geekbrains.dz2.client.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private static String nick;

    public String getNick() {
        return nick;
    }

    public static void setNick(String newNick){
        nick = newNick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        if (msg.startsWith("/auth ")) {
                            String[] data = msg.split("\\s");
                            String newNick = server.getAuthService().getNickByLoginAndPass(data[1],data[2]);
                            if (newNick !=null) {

                                nick = newNick;
                                sendMsg("/authok");
                                server.subscribe(this);
                                break;
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                    }
                    while (true) {
                        //новая строка
                        try {
                            AuthService.stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
// конец

                        String msg = in.readUTF();


                        //здесь надо поменять ник
                        getNick();
                        System.out.println(nick + ": " + msg);
                        if (msg.equals("/end")) break;
                        server.broadcastMsg(nick  + ": " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
