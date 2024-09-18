package server;

import server.Interface.ServerControllerInterface;

import javax.swing.*;
import java.awt.*;

public class ServerGUI {
    private ServerControllerInterface controller;

    public ServerGUI() {
        this.controller = controller;
        setupUI();
    }

    private void setupUI() {
        JFrame frame = new JFrame("Server GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
