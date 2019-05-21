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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

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
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password1") String password, HttpServletRequest request){
        boolean loggedIn = false;
        String userEmail = "";
        Long id = 0L;
        for (Dog dog: dogRepository.findAll()) {
            if(dog.getEmail().equals(email) && dog.getPassword().equals(password)){
                loggedIn = true;
                userEmail = dog.getEmail();
                id = dog.getId();
            }
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", loggedIn);
        session.setAttribute("email", userEmail);
        session.setAttribute("id", id);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", false);
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile(Model model, HttpServletRequest request){
        Dog user = dogInTheSession(request);
        model.addAttribute("user", user);
        if(user.getPicture()==null){
            model.addAttribute("pic", "/images/no_image_available.jpg");
        }else{
            model.addAttribute("pic", "/images/" + user.getPicture());
        }
        return "profile";
    }

    @PostMapping("/profile/update")
    public String update(@RequestParam("name") String name,@RequestParam("ownerName") String ownerName, @RequestParam("breed") String breed, @RequestParam("birthDate") String birthDate, @RequestParam("pic") String image, HttpServletRequest request){
        Dog user = dogInTheSession(request);
        user.setName(name);
        user.setOwnerName(ownerName);
        user.setBreed(breed);
        System.out.println(image + "vau");
        if(!(image.equals(""))){
            user.setPicture(image);
        }
        if(!(birthDate.equals(""))){
            String[] bDate = birthDate.split("-");
            int year = Integer.parseInt(bDate[0]);
            int month = Integer.parseInt(bDate[1]);
            int day = Integer.parseInt(bDate[2]);
            user.setBirthDate(LocalDate.of(year,month,day));
        }
        dogRepository.save(user);
        return "redirect:/profile";
    }

    public Dog dogInTheSession(HttpServletRequest request){
        Dog user = null;
        HttpSession session = request.getSession(true);
        for (Dog dog: dogRepository.findAll()) {
            if (dog.getEmail().equals(session.getAttribute("email"))){
                user = dog;
                break;
            }
        }
        return user;
    }


}
