package Main;

import client.ClientController;
import client.ClientGUI;
import server.ServerController;
import server.ServerRepository;
import server.ServerGUI;

public class Main {
    public static void main(String[] args) {

        ServerController serverController = new ServerController(new ServerGUI(), new ServerRepository());


        new ClientController(new ClientGUI(), serverController);
        new ClientController(new ClientGUI(), serverController);
    }
}
