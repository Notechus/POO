package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public class PraiseEmailHandler extends AbstractHandler {

    @Override
    public void execute(String email) {
        System.out.println("Got praise email. Forwarding to boss.");
        setNext(new StorageHandler());
        getNext().execute(email);
    }
}
