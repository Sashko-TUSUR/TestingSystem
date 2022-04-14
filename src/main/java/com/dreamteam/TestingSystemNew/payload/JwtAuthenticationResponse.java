package com.dreamteam.TestingSystemNew.payload;

import com.dreamteam.TestingSystemNew.model.Role;
import com.dreamteam.TestingSystemNew.model.User;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Role role;
    private UserProfile user;

    public JwtAuthenticationResponse(String accessToken, Role role, UserProfile user) {
        this.accessToken = accessToken;
        this.role = role;
        this.user = user;
    }
}
