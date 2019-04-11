package com.codecool.wuff.wuffproject.model;

import java.util.ArrayList;
import java.util.List;

public class Spot {

    private int id;
    private static int counterId = 0;
    private String address;
    private String description;
    private String map;
    private int likeNum;
    private List<String> comments = new ArrayList<>();

    public Spot(String address, String description, String map) {
        counterId++;
        this.id = counterId;
        this.address = address;
        this.description = description;
        this.likeNum = 0;
        this.map = map;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
