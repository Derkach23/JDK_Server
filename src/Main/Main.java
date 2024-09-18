package Main;

import server.ServerWindow;
import client.ClientGUI;

public class Main {
    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();

        new ClientGUI("127.0.0.1", 8189);
        new ClientGUI("127.0.0.1", 8189);
    }
}
