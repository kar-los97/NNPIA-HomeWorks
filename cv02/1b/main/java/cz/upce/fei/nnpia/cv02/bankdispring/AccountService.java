package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    EmailService emailService;

    public void createAccount(){
        System.out.println("Bankovní účet byl vytvořen.");
        emailService.sendEmail("karel.andres@student.upce.cz","Byl vytvořen Váš bankovní účet!");
    }

}
