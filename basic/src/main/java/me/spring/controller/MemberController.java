package me.spring.controller;

import me.spring.service.MemberService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ledgers/{ledgerId}/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Result<Void> inviteMember(@PathVariable Integer ledgerId, @RequestBody Object request) {
        return null; // TODO: implement
    }

    @PutMapping("/{memberId}")
    public Result<Void> updateRole(@PathVariable Integer ledgerId,
            @PathVariable Integer memberId, @RequestBody Object request) {
        return null; // TODO: implement
    }

    @DeleteMapping("/{memberId}")
    public Result<Void> removeMember(@PathVariable Integer ledgerId, @PathVariable Integer memberId) {
        return null; // TODO: implement
    }
}
