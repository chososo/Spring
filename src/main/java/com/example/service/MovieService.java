package com.example.service;

import com.example.domain.entity.Director;
import com.example.domain.entity.Log;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.LogRepository;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
//jPA와 연결된 것으로 하자~
@Service
@RequiredArgsConstructor
public class MovieService {
    //쿼리가 필요한 곳에서 할당을 받아서 사용하겠습니다~
    private final MovieRepository movieRepository;
    private final LogRepository logRepository;
    private final LogService logService;
    @PostConstruct
    public void init() {

    }
//단건 조회
    @Transactional
    public MovieResponse getMovie(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        // 바로 매핑 안됨. optinonal 이라서
        // orElse , 만약 업슬 때 대체할 객체를 만들어 주기ㅗㄷ 합니다. key값을 찾지 못하면 thorw문 반환

        return MovieResponse.of(movie);
    }
    // 다건 조회
    @Transactional
    public List<MovieResponse> getMovies(Integer overYear) {
        List<Movie> movies = movieRepository.findByProductionYear(2005);

        return movies.stream().map(MovieResponse::of).toList();
    }
//Transaction 붙으면 영속성의 객체가 된다.
    //Required는 default 입니다.
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveMovie(MovieRequest movieRequest) {
        //데이터 저장, Persist가 들어가야해요
        Movie movie = new Movie(movieRequest.getName()+"1",movieRequest.getProductionYear());
        movieRepository.save(movie); // 영속성에 저장하는 단계

//        Movie movie2 = new Movie(movieRequest.getName()+"2",movieRequest.getProductionYear());
//        movieRepository.save(movie2); // 영속성에 저장하는 단계
//
//        Movie movie3 = new Movie(movieRequest.getName()+"3",movieRequest.getProductionYear());
//        movieRepository.save(movie3); // 영속성에 저장하는 단계
        logService.saveLog();

        //logService.saveLog();
     //   throw new RuntimeException("강제에러 with log");
    }
    @Transactional
    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        movie.setName("변경1");
        //조회 쿼리가 한번 된 순간 이 트랜젝션이 조회가 되었기 때문에 write 쿼리가 안되는 것이다.
        // 따라서 Transaction으로 나눠주겠다.
        // 이것이 dirtychecking 그 자체이다.
        movie.setName("변경2");
        movie.setName("변경3");

    }
    // 단건 삭제
@Transactional
    public void removeMovie(long movieId) {
        //조회 후 삭제
    // 영속성의 대상이 되는 객체를 들고올게요~

    Movie movie = movieRepository.findById(movieId).orElseThrow();

    movieRepository.delete(movie);
    }

    //requires_new -> 트랜젝션을 분리한다! 라고 생각하는 것이다.


}
