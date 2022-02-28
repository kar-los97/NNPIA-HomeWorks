package com.example.controllerandservicehw.Services;

import com.example.controllerandservicehw.Model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FormService {

    private int numberOfSendingForm = 0;

    public void sendData(User user) {
        System.out.println("First name: "+user.getFirstName());
        System.out.println("Last name: "+user.getLastName());
        System.out.println("Email: "+user.getEmail());
        numberOfSendingForm++;
    }

    public int getNumberOfSendingForm(){
        return numberOfSendingForm;
    }


}
