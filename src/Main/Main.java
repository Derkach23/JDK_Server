package Main;

public interface ServerControllerInterface {
    void startServer();
    void stopServer();
    void broadcastMessage(String message);
}

