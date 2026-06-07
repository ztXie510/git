package com.example.ffms.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * System user — registered users of the FFMS platform.
 * Roles: OWNER / ADMIN / MEMBER.
 */
@Getter
@Setter
public class SysUser extends IdEntity {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String nickname;
    private String avatarUrl;
    /** OWNER | ADMIN | MEMBER */
    private String role;
    /** ACTIVE | DISABLED */
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;
}
