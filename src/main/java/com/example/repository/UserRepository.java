package com.example.repository;

import com.example.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    //User 이름으로 이름을 가져옵니다. username으로 하나만
    User findByUsername(String username);
}
