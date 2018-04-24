package me.notechus.poo.lista7.zad3;

import org.junit.Test;

/**
 * @author notechus.
 */
public class HandlerTest {


    @Test
    public void testOrderChain() {
        Handler h = new FilteringHandler();
        h.execute("Hello. I would like to place an order. Blah blah");
    }

    @Test
    public void testPraiseChain() {
        Handler h = new FilteringHandler();
        h.execute("Hello. I've got your message. Good job guys. Take care.");
    }

    @Test
    public void testComplaintChain() {
        Handler h = new FilteringHandler();
        h.execute("Hello this is complaint. Hello this is complaint.Hello this is complaint" +
                "Hello this is complaintHello this is complaintHello this is complaintHello this is complaint" +
                "Hello this is complaintHello this is complaintHello this is complaintHello this is complaint" +
                "Hello this is complaintHello this is complaintHello this is complaintHello this is complaint");
    }

    @Test
    public void testOtherChain() {
        Handler h = new FilteringHandler();
        h.execute("Hello. This is some random email. Bye, Bob");
    }

}