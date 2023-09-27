//package com.example.service;
//
//import com.example.domain.response.MovieResponse;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//// 여기에는 Lombok이 없다!
//
//@SpringBootTest
//public class MovieServiceTest {
//
//    //Lobmbok이 없어서 주입을 해줘야함
//    @Autowired
//    private MovieService movieService;
//
//    @Test
//    @DisplayName("영화 단건 조회")
//    //이름 명에 규칙은 없지만 권장사항 (~~~Test)
//    public void getMovieTest(){
//        //given
//        int movieId = 1; // 있는 번호 쓰세요~
//        //when
//        MovieResponse movieResponse = movieService.getMovie(movieId);
//        //then  : movie 는 null이 아닐거야~
//        assertNotNull(movieResponse);
//
//    }
//
//
//    @Test
//    @DisplayName("영화 다건 조회")
//    //이름 명에 규칙은 없지만 권장사항 (~~~Test)
//    public void getMoviesTest(){
//        //given
//        int productionYear = 2000;
//        //when
//        List<MovieResponse> movieResponse = movieService.getMovies(productionYear);
//        //then  : movie 는 null이 아닐거야~
//        assertNotNull(movieResponse);
//
//    }
//
//    @Test
//    @DisplayName("영화 다건 불가 조회")
//    //이름 명에 규칙은 없지만 권장사항 (~~~Test)
//    public void getMoviesFaileTest(){
//        //given
//        int productionYear = 'n';
//        //when
//        List<MovieResponse> movieResponse = movieService.getMovies(productionYear);
//        //then  : movie 는 null이 아닐거야~
//
//        assertNotNull(movieResponse);
//
//    }
//}
