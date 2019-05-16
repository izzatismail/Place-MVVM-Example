package com.izzatismail.place_mvvmexample.Models;

public class NicePlace {

    private String title;
    private String imageURL;

    public NicePlace(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public NicePlace() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
