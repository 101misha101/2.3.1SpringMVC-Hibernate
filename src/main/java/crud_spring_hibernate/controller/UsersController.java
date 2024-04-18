package crud_spring_hibernate.controller;

import crud_spring_hibernate.model.User;
import crud_spring_hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> resultList = userService.getUserList();
        model.addAttribute("users", resultList);
        return "show-all-users";
    }

    @GetMapping(value = "/newUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-new-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(Model model, @RequestParam("userId") int id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "add-new-user";
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam("userId") int id) {
        userService.removeUser(id);
        return "redirect:/";

    }


}
