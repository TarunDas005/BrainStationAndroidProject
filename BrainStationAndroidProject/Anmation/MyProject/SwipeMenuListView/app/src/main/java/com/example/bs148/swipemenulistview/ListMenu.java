package com.example.bs148.swipemenulistview;

/**
 * Created by BS148 on 9/25/2016.
 */

public class ListMenu {
    private int imageId;
    private String name;

    public ListMenu(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
