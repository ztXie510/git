package me.spring.service;

import java.util.List;

public interface MemberService {
    void inviteMember(Integer ledgerId, Integer inviterId, String usernameOrEmail);
    void removeMember(Integer ledgerId, Integer memberId);
    void updateRole(Integer ledgerId, Integer memberId, String newRole);
    List<MemberService.MemberDto> listMembers(Integer ledgerId);

    @lombok.Data
    @lombok.AllArgsConstructor
    class MemberDto {
        private Integer userId;
        private String username;
        private String nickname;
        private String role;
        private String joinedAt;
    }
}
