package com.example.service;

import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
//jPA와 연결된 것으로 하자~
@Service
@RequiredArgsConstructor
public class MovieService {
    private final EntityManagerFactory emf ;
    //쿼리가 필요한 곳에서 할당을 받아서 사용하겠습니다~
    private final List<Movie> movies = new ArrayList<>();
    private final MovieRepository movieRepository;
    @PostConstruct
    public void init() {

    }
//단건 조회
    public MovieResponse getMovie(long movieId) {
        EntityManager entityManager = emf.createEntityManager();
        Movie movie =entityManager.find(Movie.class,movieId);
        return MovieResponse.of(movie);
    }

    public List<MovieResponse> getMovies(Integer overYear) {
return null;
    }

    @Transactional
    public void saveMovie(MovieRequest movieRequest) {
        //데이터 저장, Persist가 들어가야해요
        EntityManager entityManager = emf.createEntityManager();


    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {

    }

    public void removeMovie(long movieId) {

    }
}
