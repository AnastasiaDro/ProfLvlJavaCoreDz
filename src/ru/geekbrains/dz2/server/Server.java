package ru.geekbrains.dz2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private Vector<ClientHandler> clients;
    AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            clients = new Vector<>();
            authService = new AuthService();
    //FIXME
    //Сюда вставили executorService
            ExecutorService executorService = Executors.newCachedThreadPool();
     //FIXME


            authService.connect();
            System.out.println("ServerMain started...Waiting for clients");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getInetAddress() + " " + socket.getPort() + " " + socket.getLocalPort());



  //вот тут добавляем executorServise
                new ClientHandler(this, socket);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Не удалось запустить сервис авторизации");
        } finally {
            authService.disconnect();
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public void broadcastMsg(String msg){
        for (ClientHandler o: clients){
            o.sendMsg(msg);
        }
    }
}

