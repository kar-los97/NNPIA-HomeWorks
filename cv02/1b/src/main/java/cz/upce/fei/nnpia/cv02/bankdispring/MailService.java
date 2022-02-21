package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    public void sendEmail(String to, String message) {
        System.out.println("Sending email to: " + to + " with message: " + message);
    }
}
