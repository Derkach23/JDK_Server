package server.Interface;

import java.util.List;

public interface ServerRepositoryInterface {
    void saveMessage(String message);
    List<String> getMessages();
}
