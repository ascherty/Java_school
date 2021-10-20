package com.dtlogistics.controllers;

import com.dtlogistics.dto.UserDTO;
import com.dtlogistics.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String usersAll(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/usersAll";
    }

    @GetMapping("/{name}")
    public String userDetails(@PathVariable("name") String name, Model model) {
        model.addAttribute("user", userService.findUser(name));
        return "users/userDetails";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "users/userNew";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") UserDTO userDto, Model model) {
        userService.saveUser(userDto);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") UserDTO userDto, Model model) {
        userService.updateUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("/delete/{name}")
    public String deleteUser(@PathVariable("name") String name) {
        userService.deleteUser(name);
        return "redirect:/users";
    }
}
