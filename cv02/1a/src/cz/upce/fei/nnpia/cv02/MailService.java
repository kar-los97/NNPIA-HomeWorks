package cz.upce.fei.nnpia.cv02;

public class MailService {
    public MailService() {
        System.out.println("Creating instance of email service");
    }

    public void sendEmail(String to, String message) {
        System.out.println("Sending email to: " + to + " with message: " + message);
    }
}
