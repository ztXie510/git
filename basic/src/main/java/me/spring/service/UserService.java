package me.spring.service;

import me.spring.dto.request.*;
import me.spring.dto.response.*;

public interface UserService {
    LoginResponse login(LoginRequest request);
    LoginResponse register(RegisterRequest request);
    LoginResponse refreshToken(RefreshTokenRequest request);
    void resetPassword(PasswordResetRequest request);
    UserInfoResponse getUserInfo(Integer userId);
    UserInfoResponse updateProfile(Integer userId, RegisterRequest request);
    void logout(String accessToken);
}
