package com.codecool.wuff.wuffproject.controller;

import com.codecool.wuff.wuffproject.model.Newsfeed;
import com.codecool.wuff.wuffproject.repository.NewsFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @GetMapping("/index")
    public String newsFeed(Model model) {
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
