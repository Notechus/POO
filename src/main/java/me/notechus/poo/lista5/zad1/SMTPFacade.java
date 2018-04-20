package me.notechus.poo.lista5.zad1;

import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author notechus.
 */
public class SMTPFacade {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SMTPFacade.class);

    private String username;
    private String password;
    private Properties properties;
    private Session session;

    public SMTPFacade(String username, String password, Properties properties) {
        this.username = username;
        this.password = password;
        this.properties = properties;
        session = Session.getInstance(this.properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    void send(String from, String to, String subject, String body, InputStream attachment, String mimeType) {
        if (session == null) {
            throw new RuntimeException("You were disconnected from the SMTP server");
        }
        try {
            Message msg = createMessage(from, to, subject, body);
            Multipart at = createAttachment(attachment, mimeType);
            msg.setContent(at);

            Transport.send(msg);
            logger.info("Successfully sent the message to {}", to);
        } catch (MessagingException | IOException e) {
            logger.error("Could not send message", e);
        }

    }

    private Message createMessage(String from, String to, String subject, String body) throws MessagingException {
        Message msg = new MimeMessage(this.session);
        msg.setFrom(new InternetAddress(from));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(body);

        return msg;
    }

    private Multipart createAttachment(InputStream attachment, String mimeType) throws IOException, MessagingException {
        Multipart multi = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        ByteArrayDataSource dataSource = new ByteArrayDataSource(attachment, mimeType);
        bodyPart.setDataHandler(new DataHandler(dataSource));
        bodyPart.setFileName("attachment." + mimeType.split("/")[1]);

        multi.addBodyPart(bodyPart);

        return multi;
    }
}
