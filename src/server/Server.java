package server;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Server {
    private static final int PORT = 8189;
    private List<ClientHandler> clients = new ArrayList<>();
    private ServerSocket serverSocket;
    private JTextArea logArea;

    public Server(JTextArea logArea) {
        this.logArea = logArea;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            logMessage("Сервер запущен на порту " + PORT);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket, this);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            logMessage("Ошибка: " + e.getMessage());
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
            logMessage("Сервер остановлен.");
        } catch (IOException e) {
            logMessage("Ошибка при остановке сервера: " + e.getMessage());
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
        saveMessageToFile(message);
    }

    private void saveMessageToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chat_history.txt", true))) {
            writer.write(message + "\n");
        } catch (IOException e) {
            logMessage("Ошибка сохранения сообщения: " + e.getMessage());
        }
    }

    private void logMessage(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }
}
