package lt.sdacademy.hashmap;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @Test
    public void testLike() {
        User luke = new User("Luke");
        User simona = new User("Simona");

        Message message = new Message(luke, "Just left work");
        message.new Like(simona);
        // -> 'Simona liked "Just left work"'
    }
    @Test
    public void testEitherOr() {
        EitherOr<String, Integer> eo1 = EitherOr.either("Luke");

        Assert.assertTrue(eo1.isEither());
        Assert.assertFalse(eo1.isOr());
        Assert.assertEquals("Luke", eo1.getEither());
    }
    @Test
    public void testPredicate() {
        List<String> myList = Arrays.asList("Luke", "Simona", null);

        List<String> result = myList.stream().filter(o -> o != null).collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList("Luke", "Simona"), result);
    }
}
