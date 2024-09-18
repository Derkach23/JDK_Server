package client;

public interface ClientControllerInterface {
    void connectToServer();
    void sendMessage(String message);
    void disconnect();
}
