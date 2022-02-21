package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ShoppingCartService {

    public void createShoppingCart(){
        System.out.println("Vytvářím nákupní košík pro nového uživatele...");
    }

    public void getSumOfShoppingCart(){
        System.out.println("Aktuálně máte v košíku zboží za: "+ new Random().nextInt());
    }

    public void addAmountToShoppingCart(int amount){
        System.out.println(amount+" bude přičteno k vašemu nákupnímu košíku");
    }

}
