package by.project.courierexchange.util;



/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSendler extends Thread {
    private String username;
    private String password;
    private String title;
    private String recipientMail;
    private String message;

    public MailSendler(String username, String password, String title, String recipientMail, String message) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.recipientMail = recipientMail;
        this.message = message;
    }

    @Override
    public void run() {
        Properties sesiionConfig = new Properties();
        sesiionConfig.setProperty("mail.smtps.host", "smtp.gmail.com");
        sesiionConfig.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sesiionConfig.setProperty("mail.smtp.socketFactory.fallback", "false");
        sesiionConfig.setProperty("mail.smtp.socketFactory.port", "465");
        sesiionConfig.setProperty("mail.smtp.port", "465");
        sesiionConfig.setProperty("mail.smtps.auth", "true");
        sesiionConfig.setProperty("mail.transport.protocol", "smtp");
        sesiionConfig.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getInstance(sesiionConfig);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(username + "@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientMail, false));
            mimeMessage.setSubject(title);
            mimeMessage.setText(message, "UTF-8");
            mimeMessage.setSentDate(new Date());

            try (SMTPTransport transport = (SMTPTransport) session.getTransport("smtps")) {
                transport.connect("smtp.gmail.com", username, password);
                transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("ok thread");
    }
}*/
