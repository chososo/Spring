package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@Getter
@Table(name="movie")
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="production_year")
    private int productionYear;
    @Column(name="created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // 기본생성자가 arg 없는 생성자 만들어 줘야합니다.
    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear=productionYear;

    }

//    @Column(name="director_id")
//    private LocalDateTime directorId;


}
