package com.example.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
//id 대신에 username
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name="role")
    private String role;
    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
