package lt.sdacademy.hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conversations {
    private Map<List<User>, List<Message>> threads = new HashMap<List<User>, List<Message>>();

    public void addMessageToGroup(List<User> group, Message message) {
        List<Message> thread = threads.get(group);

        if (thread == null) {
            thread = new ArrayList<Message>();
            threads.put(group, thread);
        }

        thread.add(message);
    }

    public List<Message> listMessages(List<User> group) {
        return threads.get(group);
    }
}