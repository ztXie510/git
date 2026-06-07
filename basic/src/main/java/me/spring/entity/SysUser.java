package me.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * System user — registered users of the FFMS platform.
 * Roles: OWNER / ADMIN / MEMBER.
 */
@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class SysUser extends IdEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 50)
    private String nickname;

    @Column(length = 255)
    private String avatarUrl;

    /** OWNER | ADMIN | MEMBER */
    @Column(nullable = false, length = 20)
    private String role;

    /** ACTIVE | DISABLED */
    @Column(nullable = false, length = 20)
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) status = "ACTIVE";
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
