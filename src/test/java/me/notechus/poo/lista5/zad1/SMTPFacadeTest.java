package me.notechus.poo.lista5.zad1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author notechus.
 */
public class SMTPFacadeTest {

    private static final String username = "metodyki.zwinne2016@gmail.com";
    private static final String password = "zwinne2016";

    @Test
    public void testSendEmail() throws FileNotFoundException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");

        SMTPFacade smtpFacade = new SMTPFacade(username, password, properties);

        smtpFacade.send(username, "seba0713@gmail.com", "POO 2018 SMTP test", "Test message",
                new FileInputStream("src/test/resources/zad1/file.pdf"), "application/pdf");
    }

}