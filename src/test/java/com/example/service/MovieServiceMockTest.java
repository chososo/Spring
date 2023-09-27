package com.example.service;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.request.MovieRequest;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private LogService logService;

    // 이 두개를 movie service에 넣얼 줄거에요
    @InjectMocks
    private MovieService movieService;

    @Test
    public void 영화단건조회_정상조회_테스트(){
        //given
        int movieId = 3;
        Movie movie = new Movie();
        movie.setName("목테스트");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

//        //when from mockito
//        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        //movie의 findbyID는 key라서 Long 타입. -> 이 안에 String 같은 걸 넣으면 오류가 난다.
        //객체면 any 로 넣으면 된당 (만능)
        //then
        MovieResponse movieResponse = movieService.getMovie(movieId);
//        assertNotNull(result);
        assertNotNull(movieResponse);
    }
    @Test
    public void 영화단건조회_불가_테스트(){
        //given
        int movieId = 3;
        Movie movie = new Movie();
        movie.setName("목테스트");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

//        //when from mockito
//        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        //when
        when(movieRepository.findById(anyLong())).thenReturn(null);
        //movie의 findbyID는 key라서 Long 타입. -> 이 안에 String 같은 걸 넣으면 오류가 난다.
        //객체면 any 로 넣으면 된당 ( 만능)
        //then
//        assertNotNull(result);
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }


    @Test
    public void 영화단건저장_불가_테스트(){
        MovieRequest request =  new MovieRequest("영화1",2022, 1L);
        Movie movie = new Movie("영화1",2022);
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();
        movieService.saveMovie(request);
    }
}
