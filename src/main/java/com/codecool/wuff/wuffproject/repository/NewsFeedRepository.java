package com.codecool.wuff.wuffproject.repository;

import com.codecool.wuff.wuffproject.model.Newsfeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsFeedRepository  extends JpaRepository<Newsfeed, Long> {

}
