package lt.sdacademy.hashmap;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class HashMapTest {
    @Test
    public void testHashmap() {
        User luke = new User("Luke");
        User simona = new User("Simona");

        List<User> group = Arrays.asList(luke, simona);

        Conversations conversations = new Conversations();

        conversations.addMessageToGroup(group, new Message(luke, "Hey, what's up"));
        conversations.addMessageToGroup(group, new Message(simona, "Good, how are you?"));

        List<User> sameGroupButDuplicated = Arrays.asList(new User("Luke"), new User("Simona"));
        List<Message> thread = conversations.listMessages(sameGroupButDuplicated);

        Assert.assertEquals(2, thread.size());
        Assert.assertEquals("Good, how are you?", thread.get(1).getText());
        // TODO Assertions about message content
    }
}
