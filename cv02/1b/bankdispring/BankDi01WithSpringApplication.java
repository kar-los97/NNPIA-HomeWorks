package cz.upce.fei.nnpia.cv02.bankdispring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BankDi01WithSpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cz.upce.fei.nnpia.cv02.bankdispring");
        context.getBean(BankApp.class).process();
    }

}
