package com.codecool.wuff.wuffproject.controller;

import com.codecool.wuff.wuffproject.model.Dog;
import com.codecool.wuff.wuffproject.model.Newsfeed;
import com.codecool.wuff.wuffproject.repository.DogRepository;
import com.codecool.wuff.wuffproject.repository.NewsFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private NewsFeedRepository newsFeedRepository;
    @Autowired
    private DogRepository dogRepository;

    @GetMapping
    public String indexPage(Model model, HttpServletRequest request) {
        HttpSession session =  request.getSession(true);
        if(session.getAttribute("loggedIn") == null) {
            session.setAttribute("loggedIn", false);
        }

        model.addAttribute("comments", newsFeedRepository.findAll(new Sort(Sort.Direction.DESC,"birthDate")));
        return "index";
    }

    @PostMapping("/index/comment")
    public String commentOnNewsFeed(@RequestParam("inComment") String inComment, HttpServletRequest request){
        Long userId = null;
        HttpSession session = request.getSession(true);
        for (Dog dog: dogRepository.findAll()) {
            if (dog.getEmail().equals(session.getAttribute("email"))){
                userId = dog.getId();
                break;
            }
        }

        Newsfeed newsFeed = Newsfeed.builder()
                .birthDate(LocalDateTime.now())
                .comment(inComment)
                .userId(userId)
                .build();
        newsFeedRepository.save(newsFeed);
        return "redirect:/";
    }


}
