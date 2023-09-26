package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
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

//    @Column(name="director_id")
//    private Long directorId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    // Collection 타입을 그냥 매핑이 안돼요...
    private List<Actor> actors;

    // 기본생성자가 arg 없는 생성자 만들어 줘야합니다.
    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear=productionYear;

    }

//    @Column(name="director_id")
//    private LocalDateTime directorId;


}
