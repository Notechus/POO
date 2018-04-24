package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public class OtherEmailHandler extends AbstractHandler {
    @Override
    public void execute(String email) {
        System.out.println("Unrecognized category of email. Forwarding to common mailbox.");
        setNext(new StorageHandler());
        getNext().execute(email);
    }
}
