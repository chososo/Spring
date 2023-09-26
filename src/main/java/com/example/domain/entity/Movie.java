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



    // 기본생성자가 arg 없는 생성자 만들어 줘야합니다.
    public Movie(String name, int productionYear){
        this.name = name;
        this.productionYear=productionYear;

    }


    @OneToMany(
            mappedBy = "movie",
            fetch = FetchType.LAZY,
            //cascade : fk 가 설정되어있는 db 에서 부모 또는 자원의 key가 되는 대상이 삭제 도미ㅕㄴ
            // 관계되어있는 녀석들도 어떻게 하겠다~ 로 설정하는 것이다.
            //move 객체가 생성될때 어떻게 하겠다~
            // 모든것을 같이하는 걸로 일단 둘게요
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Actor> actors;
//    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
//    // Collection 타입을 그냥 매핑이 안돼요...
//    private List<Actor> actors;
//    @Column(name="director_id")
//    private LocalDateTime directorId;


}
