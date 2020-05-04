package com.fileshare.auth.controller;

import com.fileshare.auth.UserValidator;
import com.fileshare.auth.model.User;
import com.fileshare.auth.services.SecurityService;
import com.fileshare.auth.services.UserService;
import com.fileshare.models.Folder;
import com.fileshare.repositories.FolderRepository;
import com.fileshare.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User newUser = userService.save(userForm);
        folderRepository.save(new Folder(userForm.getUsername(), newUser));
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        fileStorageService.createDir("", userForm.getUsername());
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}