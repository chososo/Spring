package com.example.service;

import com.example.domain.entity.User;
import com.example.domain.request.UserRequest;
import com.example.domain.response.UserResponse;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    //회원 가입 : DB 에다 넣는 로직을 짜면 됩니다~

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void join(UserRequest userRequest ){
            // encoding 을 안한 상태, 이제 해줘야함 => 나중에 encoding을 안하면 DB 조회가 아예 안되기도한다.
        User user = new User(userRequest.getUsername(),passwordEncoder.encode(userRequest.getPassword()),userRequest.getRole());
        userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        //User 를 받아왔다.
        // UserDetails : interface다. 권한 정보/ Password Username 등을 가지고 있다.
        // 따라서 user를 바로 반환할 수 없다.
        // userDetails를 반환하는 구현체를 만들어줘야한다.
        // Response 객체를 만들어서 deatils형태로 만들어줘얗반디ㅏ
        return UserResponse.of(user);
    }
}
