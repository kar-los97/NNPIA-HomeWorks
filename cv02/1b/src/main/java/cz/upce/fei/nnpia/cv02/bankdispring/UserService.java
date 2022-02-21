package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private MailService mailService;

    public UserService(ShoppingCartService shoppingCartService,MailService mailService) {
        this.shoppingCartService = shoppingCartService;
        this.mailService = mailService;
    }

    public void createUser() {
        System.out.println("Vytvářím uživatele...");
        shoppingCartService.createShoppingCart();
        mailService.sendEmail("karel.andres@student.upce.cz","Byl vytvořen váš učet a váš nákupní košík...");
    }

}
