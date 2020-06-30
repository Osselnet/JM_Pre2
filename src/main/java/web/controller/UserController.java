package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;


import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    protected UserService userService;

    @GetMapping("/")
    public String listPage(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        //userRepository.save(user);
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        //userRepository.save(user);
        model.addAttribute("users", userService.getAllUser());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        //User user = userService.getUserById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }
}