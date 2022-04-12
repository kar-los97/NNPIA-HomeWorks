package cz.upce.orm_jpa.repository;

import cz.upce.orm_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query
    List<User> findUsersByUserNameContains(String containsString);
}
