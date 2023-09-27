package com.example.controller;

import com.example.domain.request.UserRequest;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Service의 join 을 호출하기 위해 있는 Controller
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/api/v1/user/join")
    public void join( @RequestBody UserRequest userRequest
    ){
            userService.join(userRequest);
    }
    @GetMapping("/home")
    public String home(){
        return " 어서왕 로그인 성공 ~ ㅊㅋㅊㅋ ";
    }
    @GetMapping("/admin")
    public String adimin(){
        return  " 어드 민만 접속 가능 ㅇ뇽케 들어왔네 !!! " ;

    }
    @GetMapping("/manager")
    public String manager(){
        return "매니저까지 접속한 홤연에 들어왔뗘~!~!~!~!!~!~!~~!";
    }


}
