package com.example.controllerandservicehw.Services;

import com.example.controllerandservicehw.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> addedUsers = new ArrayList<>();

    public boolean addUser(User user){
        if(user!=null) {
            addedUsers.add(user);
            return true;
        }else{
            return false;
        }
    }

    public List<User> getAddedUsers(){
        return addedUsers;
    }

    public boolean deleteUser(int id){
        if(id<addedUsers.size() && id>=0) {
            addedUsers.remove(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteAllUsers(){
        addedUsers.clear();
        return true;
    }
}
