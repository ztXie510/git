package me.spring.controller;

import me.spring.dto.request.*;
import me.spring.dto.response.LoginResponse;
import me.spring.service.UserService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest request) {
        return null; // TODO: implement
    }

    @PostMapping("/register")
    public Result<LoginResponse> register(@RequestBody RegisterRequest request) {
        return null; // TODO: implement
    }

    @PostMapping("/refresh")
    public Result<LoginResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
        return null; // TODO: implement
    }

    @PostMapping("/logout")
    public Result<Void> logout(@RequestHeader("Authorization") String token) {
        return null; // TODO: implement
    }

    @PostMapping("/password/reset")
    public Result<Void> resetPassword(@RequestBody PasswordResetRequest request) {
        return null; // TODO: implement
    }
}
