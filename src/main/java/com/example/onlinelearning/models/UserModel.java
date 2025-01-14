package com.example.onlinelearning.models;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    private String detail;
    private String imgUrl;
    @Column(name = "registration_date")
    private LocalDate date;

    public UserModel(String username, String password, String name, String surname, String email, String imgUrl, LocalDate date) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public UserModel(String detail) {
        this.detail = detail;
    }
}
