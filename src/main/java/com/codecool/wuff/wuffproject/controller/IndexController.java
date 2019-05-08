package com.codecool.wuff.wuffproject.controller;

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

    @GetMapping("/index")
    public String newsFeed(Model model, HttpServletRequest request) {
        HttpSession session =  request.getSession(true);
        if(session.getAttribute("loggedIn") == null) {
            session.setAttribute("loggedIn", false);
        }

//        System.out.println(session.getAttribute("loggedIn"));
//        System.out.println(session.getAttribute("email"));

        model.addAttribute("comments", newsFeedRepository.findAll(new Sort(Sort.Direction.DESC,"birthDate")));
        return "index";
    }

    @PostMapping("/index/comment")
    public String commentOnNewsFeed(@RequestParam("inComment") String inComment){
        Newsfeed newsFeed = Newsfeed.builder()
                .birthDate(LocalDateTime.now())
                .comment(inComment)
                .build();
        newsFeedRepository.save(newsFeed);
        return "redirect:/index";
    }
}
