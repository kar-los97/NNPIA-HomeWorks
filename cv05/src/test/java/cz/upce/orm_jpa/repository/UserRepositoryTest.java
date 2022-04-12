package cz.upce.orm_jpa.repository;

import cz.upce.orm_jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    void saveUser(){
        User user = new User();
        user.setUserName("Petr Kalný");
        user.setEmail("petr@kalny.cz");
        user.setPhone("+420132456789");
        userRepository.save(user);
    }

    @Test
    void getUsersByUserNameContains(){
        List<User> users = userRepository.findUsersByUserNameContains("ka");
        for(User user: users){
            System.out.println(user);
        }
    }
}