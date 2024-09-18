package server;

import server.Interface.ServerControllerInterface;
import server.Interface.ServerRepositoryInterface;

import java.io.*;
import java.net.*;

public class ServerController implements ServerControllerInterface {
    private ServerRepositoryInterface repository;
    private ServerSocket serverSocket;

    public ServerController(ServerGUI serverGUI, ServerRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void startServer() {
        try {
            serverSocket = new ServerSocket(8189);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void broadcastMessage(String message) {
        repository.saveMessage(message);

    }

    private class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

        }
    }
}
