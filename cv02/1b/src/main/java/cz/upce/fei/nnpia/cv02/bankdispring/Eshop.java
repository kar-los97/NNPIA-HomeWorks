package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Eshop implements IBankApp{
    @Autowired
    UserService userService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @Override
    public void process(){
        userService.createUser();
        shoppingCartService.getSumOfShoppingCart();
        shoppingCartService.addAmountToShoppingCart(50);
    }
}
