package me.notechus.poo.lista8.zad4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author notechus.
 */
public class MailboxTest {

    private Mailbox mailbox = new Mailbox();


    @Test(expected = IllegalArgumentException.class)
    public void testMailboxFlow() {
        Message m = createMessage();

        mailbox.processMessage(m, ActionType.MARK_READ);
        assertEquals(MessageStateType.READ, m.getState());

        mailbox.processMessage(m, ActionType.ARCHIVIZE);
        assertEquals(MessageStateType.ARCHIVED, m.getState());

        mailbox.processMessage(m, ActionType.MOVE_TO_TRASH);
        assertEquals(MessageStateType.IN_TRASH, m.getState());

        mailbox.processMessage(m, ActionType.DELETE_PERMANENTLY);
        assertEquals(MessageStateType.DELETED, m.getState());

        mailbox.processMessage(m, ActionType.MARK_READ);
    }

    private Message createMessage() {
        Message m = new Message();
        m.setRecipient("L");
        m.setAuthor("S");
        m.setMessage("Hello");

        return m;
    }
}