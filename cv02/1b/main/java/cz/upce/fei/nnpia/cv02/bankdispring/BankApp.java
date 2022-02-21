package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankApp implements IBankApp{
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @Override
    public void process(){
        userService.createUser();
        accountService.createAccount();
    }
}
