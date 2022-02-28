package com.example.controllerandservicehw.Controllers;

import com.example.controllerandservicehw.Model.User;
import com.example.controllerandservicehw.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addUser(@ModelAttribute("user") User user, Model model){
        userService.addUser(user);
        return true;
    }

    @GetMapping(value = "/get")
    public String getUser(@RequestParam(value = "id",required = true,defaultValue = "0") Integer id,Model model){
        User user = userService.getAddedUsers().get(id);
        model.addAttribute("user",user);
        model.addAttribute("numberOfSendsForm",0);
        return "output_of_form";

    }

    @GetMapping(value = "/getAll")
    public String getUsers(Model model){
        List<User> users = userService.getAddedUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @DeleteMapping(value="/deleteAll")
    public String deleteUser(Model model){
        int number = userService.getAddedUsers().size();
        userService.deleteAllUsers();
        model.addAttribute("number",number);
        return "delete";
    }

    @DeleteMapping(value="/delete")
    public String deleteUser(@RequestParam(value = "id",required = false,defaultValue = "") String id,Model model){
        try {
            int idNum = Integer.parseInt(id);
            userService.deleteUser(idNum);
            model.addAttribute("number",1);
        }catch (NumberFormatException ex){
            model.addAttribute("number",0);
        }
        return "delete";
    }

}
