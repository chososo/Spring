package com.example.domain.response;

import com.example.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserResponse implements UserDetails {

    private final String username;
    private final String password;
    private final String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한에 관한 내용 , 권한을 부여하자! 인가
        // 권한을 처리하는 변수가 필요합니다.

        //collection이 List 포함함!
        return List.of(new SimpleGrantedAuthority(role));
        //db 에 있는 role 정보를 읽어와서 얘랑 SecurityConfig에 정의해놓은 hasrole을 매핑해줘서 처리함!

    }

    @Override
    public boolean isAccountNonExpired() {
        // Expired 시키지 않을 거니? 네~ ( true ) 회원가입 6개월 지남 .세션 만료~ 어쩌구 저쩌구
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //account lock 할거니?
        return true; // 아니
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //아니
    }

    @Override
    public boolean isEnabled() {
        return true; // 아니~
    }

    public static UserResponse of(User user){
        return new UserResponse(user.getUsername(), user.getPassword(), user.getRole());
    }
}
