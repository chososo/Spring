package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// T > 매핑할 객체  Td > T값의 타입 // => movie 객체와 키값의 타입인 long
public interface MovieRepository<Movie> extends JpaRepository<Movie, Long> {


}
