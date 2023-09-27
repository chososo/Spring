package com.example.common.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //request를 받으면 intercept할 수 있는 요소를 만들어야 한다.
    //bean(filter chain)을 통해서 security를 확인하는 과정을 만들어 보자

    // Ioc container에 filterchian 프로세스가 들어있따.
    //filter chain이 intercept해서 Http Security 정보를 받아오도록 한다.
    // 이 친구를 통해서 Security 설정을 할 수 있다.

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                 csrf().disable()
                .formLogin()
                .defaultSuccessUrl("/home")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
//                .and().build();
        return httpSecurity
                .authorizeRequests(auth ->
                        auth.antMatchers("/api/v1/user/join","/login").permitAll()
                        //아무나 접근가능함
                        //secure 된 것이라는 걸 표현하는 방패!
                                .antMatchers("/admin").hasRole("ADMIN")
                                .antMatchers("/manager").access("hasRole('ADMIN') or hasRole('MANAGER')")
                                // admin 페이지는 admin만, manager 페이지는 amdin과 manager
                                .anyRequest().authenticated() // 권한없이는 못들어와
                ).build();
                //cross site ....  csrf , security 관련 단어들이 있다. /

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

}
