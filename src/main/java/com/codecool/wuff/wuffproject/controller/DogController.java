package com.codecool.wuff.wuffproject.controller;


import com.codecool.wuff.wuffproject.model.Dog;
import com.codecool.wuff.wuffproject.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @PostMapping("/registration")
    public String registration(Model model, @RequestParam("email") String email, @RequestParam("password1") String password1, @RequestParam("password2") String password2, @RequestParam("dogName") String dogName, @RequestParam("ownerName") String ownerName){

        if (password1.equals(password2)){
            Dog dog = Dog.builder()
                    .email(email)
                    .password(password1)
                    .name(dogName)
                    .ownerName(ownerName)
                    .build();
            dogRepository.save(dog);
        }
        model.addAttribute("exception", "Passwords are not matching");
        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password1") String password, HttpServletRequest request){
        boolean loggedIn = false;
        Long dogId = 0L;
        for (Dog dog: dogRepository.findAll()) {
            if(dog.getEmail().equals(email) && dog.getPassword().equals(password)){
                loggedIn = true;
                dogId = dog.getId();
            }
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", loggedIn);
        session.setAttribute("dogId", dogId);
        return "redirect:/index";
    }
}
