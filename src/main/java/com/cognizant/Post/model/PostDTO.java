package com.cognizant.Post.model;

public class PostDTO {
    private String img;
    private String description;

    public PostDTO(String img, String description) {
        this.img = img;
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
