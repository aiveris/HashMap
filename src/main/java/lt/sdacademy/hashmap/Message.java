package lt.sdacademy.hashmap;

public class Message {
    private final User sender;
    private final String text;

    public Message(User sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
}
