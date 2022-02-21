package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    EmailService emailService;

    public void createUser() {
        System.out.println("Uživatelský účet byl vytvořen");
        emailService.sendEmail("karel.andres@student.upce.cz", "Vítejte v naší bance! Váš uživatelský účet byl vytvořen");
    }
}
