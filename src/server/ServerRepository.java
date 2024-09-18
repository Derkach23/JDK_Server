package server;

import java.util.ArrayList;
import java.util.List;

public class ServerRepository implements ServerRepositoryInterface {
    private List<String> messages = new ArrayList<>();

    @Override
    public void saveMessage(String message) {
        messages.add(message);
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }
}
