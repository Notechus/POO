package me.notechus.poo.lista8.zad4;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author notechus.
 */
public class Message implements Serializable {

    private UUID id = UUID.randomUUID();
    private String recipient;
    private String author;
    private String message;
    private MessageStateType state = MessageStateType.RECEIVED;

    public Message() {
    }

    public Message(String recipient, String author, String message) {
        this.recipient = recipient;
        this.author = author;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageStateType getState() {
        return state;
    }

    public void setState(MessageStateType state) {
        this.state = state;
    }
}
