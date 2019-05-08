package com.codecool.wuff.wuffproject.controller;


import com.codecool.wuff.wuffproject.model.Dog;
import com.codecool.wuff.wuffproject.repository.DogRepository;
import com.codecool.wuff.wuffproject.service.EmailSender;
import com.codecool.wuff.wuffproject.service.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping
public class DogController {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private DogRepository dogRepository;

    @PostMapping("/registration")
    public String registration(Model model, @Valid @RequestParam("email") String email, @Valid @RequestParam("password1") String password1, @Valid @RequestParam("password2") String password2, @Valid @RequestParam("dogName") String dogName, @Valid @RequestParam("ownerName") String ownerName){

        Mail mail = new Mail();

        if (password1.equals(password2)){
            Dog dog = Dog.builder()
                    .email(email)
                    .password(password1)
                    .name(dogName)
                    .ownerName(ownerName)
                    .build();
            dogRepository.save( dog);

            mail.setFrom("Wuff ");
            mail.setTo(email);
            mail.setSubject("Wuff-registration");
            mail.setContent("You're registered to Wuff!"
                    + System.lineSeparator() + System.lineSeparator() + "Dear "
                    + ownerName +"," + System.lineSeparator() + "Thank you for choosing us!"
                    + System.lineSeparator() + System.lineSeparator() + "Regards,"
                    + System.lineSeparator() + "Wuff application");

            emailSender.sendSimpleMessage(mail);


        }
        return "redirect:/index";
    }
}
