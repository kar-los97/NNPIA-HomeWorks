package com.example.controllerandservicehw.Controllers;

import com.example.controllerandservicehw.Services.FormService;
import com.example.controllerandservicehw.Model.User;
import com.example.controllerandservicehw.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("form")
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getForm(@RequestParam(value = "firstName",required = false,defaultValue = "")String firstName, @RequestParam(value = "lastName",required = false,defaultValue = "")  String lastName, @RequestParam(value = "email",required = false,defaultValue = "") String email, Model model){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        model.addAttribute("user",user);
        return "form";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String sendForm(@ModelAttribute("user") User user,Model model){
        model.addAttribute("user",user);
        formService.sendData(user);
        userService.addUser(user);
        model.addAttribute("numberOfSendsForm",formService.getNumberOfSendingForm());
        return "output_of_form";
    }

}
