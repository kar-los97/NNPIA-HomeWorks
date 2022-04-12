package cz.upce.orm_jpa.repository;

import cz.upce.orm_jpa.entity.Bill;
import cz.upce.orm_jpa.entity.BillState;
import cz.upce.orm_jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    void saveBill(){
        Bill bill = new Bill();
        bill.setState(BillState.CREATED);
        User user = new User();
        user.setUserName("Petr Kalný");
        user.setEmail("petr@kalny.cz");
        user.setPhone("+420132456789");
        userRepository.save(user);
        bill.setUser(user);
        billRepository.save(bill);
    }

    @Test
    void getBillByUserId(){
        Bill bill = billRepository.getBillByUser(1);
        System.out.println(bill);
    }

    @Test
    void getBills(){
        List<Bill> bills = billRepository.findAll();
        for (Bill bill: bills){
            System.out.println(bill);
        }
    }



}