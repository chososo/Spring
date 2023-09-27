//package com.example.service;
//
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class BaseTest {
//    @BeforeAll
//    //메소드 명은 상관없음
//    public static void beforeAll(){
//        System.out.println("매 테스트 전 호출 ");
//    }
//    @BeforeEach
//    public void beforeEach(){
//        System.out.println("테스트 전 한 번 호출");
//    }
//    @AfterAll
//    public static void  afterAll(){
//        System.out.println("매 테스트 후 호출 ");
//    }
//    @AfterEach
//    public void afterEach(){
//        System.out.println("테스트 후 한 번 호출");
//    }
//    @Test
//    @DisplayName("더하기 테스트")
//    public void calTest(){
//        //given
//        int a = 1;
//        int b = 3;
//        // when
//        int sum = a+ b ;
//        //then
//        assertEquals(4,sum);
//        System.out.println("테스트 완료! ");
//    }
//}
