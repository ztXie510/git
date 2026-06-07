package me.spring.controller;

import me.spring.dto.response.UserInfoResponse;
import me.spring.service.UserService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Result<UserInfoResponse> getUser(@PathVariable Integer id) {
        return null; // TODO: implement
    }

    @GetMapping("/profile")
    public Result<UserInfoResponse> getProfile() {
        return null; // TODO: implement
    }

    @PutMapping("/profile")
    public Result<UserInfoResponse> updateProfile(@RequestBody Object request) {
        return null; // TODO: implement
    }
}
