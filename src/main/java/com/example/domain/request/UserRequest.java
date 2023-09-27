package com.example.domain.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequest {
    private final String username;
    private final String password;
    private final String role;
}
