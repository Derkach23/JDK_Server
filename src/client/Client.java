package client;

import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private ClientGUI gui;

    public Client(String serverAddress, int port, ClientGUI gui) {
        this.gui = gui;
        try {
            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            new Thread(this::receiveMessages).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            out.write(message);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                gui.addMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
