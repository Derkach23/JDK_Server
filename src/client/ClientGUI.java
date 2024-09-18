package client;

import client.Interface.ClientControllerInterface;
import client.Interface.ClientGUIInterface;

import javax.swing.*;
import java.awt.*;

public class ClientGUI implements ClientGUIInterface {
    private ClientControllerInterface controller = null;
    private JTextArea chatArea;
    private JTextField messageField;

    public ClientGUI() {
        this.controller = controller;
        setupUI();
    }

    private void setupUI() {
        JFrame frame = new JFrame("Client GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(e -> sendMessage());
        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            controller.sendMessage(message);
            messageField.setText("");
        }
    }

    @Override
    public void displayMessage(String message) {
        chatArea.append(message + "\n");
    }
}
