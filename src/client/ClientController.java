package client;

import client.Interface.ClientControllerInterface;
import client.Interface.ClientGUIInterface;
import server.ServerController;

import java.io.*;
import java.net.Socket;

public class ClientController implements ClientControllerInterface {
    private Socket socket;
    private BufferedWriter out;
    private ClientGUIInterface gui;

    public ClientController(ClientGUIInterface gui, ServerController serverController) {
        this.gui = gui;
    }

    @Override
    public void connectToServer() {
        try {
            socket = new Socket("127.0.0.1", 8189);
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new Thread(() -> {
                // Логика получения сообщений
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String message) {
        try {
            out.write(message);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
