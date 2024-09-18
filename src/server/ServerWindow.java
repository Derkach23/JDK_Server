package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private JButton startButton;
    private JButton stopButton;
    private JTextArea logArea;
    private Server server;

    public ServerWindow() {
        setTitle("Chat Server");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
    }

    private void startServer() {
        server = new Server(logArea);
        new Thread(() -> server.startServer()).start();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopServer() {
        server.stopServer();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public void logMessage(String message) {
        logArea.append(message + "\n");
    }
}