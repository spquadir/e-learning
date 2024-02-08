package com.example.foodrecipie.models;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class ImageModel {
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
