package com.studyjam.samples.imagelist.data.dto;

public class Person {
    private String name;
    private String imageUrl;

    public Person() {
    }

    public Person(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
