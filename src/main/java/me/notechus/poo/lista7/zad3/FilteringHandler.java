package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public class FilteringHandler extends AbstractHandler {

    private static final int COMPLAINT_THRESHOLD = 300;

    @Override
    public void execute(String email) {
        System.out.println("Filtering received email");
        filterEmail(email.toLowerCase());
        getNext().execute(email);
    }

    private void filterEmail(String email) {
        if (email.contains("good job")) {
            this.setNext(new PraiseEmailHandler());
        } else if (email.length() > COMPLAINT_THRESHOLD) {
            this.setNext(new ComplaintEmailHandler());
        } else if (email.contains("order")) {
            this.setNext(new OrderEmailHandler());
        } else {
            this.setNext(new OtherEmailHandler());
        }
    }
}
