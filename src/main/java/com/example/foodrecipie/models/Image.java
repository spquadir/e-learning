package com.example.foodrecipie.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {
    @Id
    private int imageID;
    private byte[] imageData;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
