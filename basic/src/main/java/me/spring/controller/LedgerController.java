package me.spring.controller;

import me.spring.service.LedgerService;
import me.spring.service.MemberService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ledgers")
public class LedgerController {

    private final LedgerService ledgerService;
    private final MemberService memberService;

    public LedgerController(LedgerService ledgerService, MemberService memberService) {
        this.ledgerService = ledgerService;
        this.memberService = memberService;
    }

    @PostMapping
    public Result<?> createLedger(@RequestBody Object request) { return null; }

    @GetMapping("/{id}")
    public Result<?> getLedger(@PathVariable Integer id) { return null; }

    @PutMapping("/{id}")
    public Result<?> updateLedger(@PathVariable Integer id, @RequestBody Object request) { return null; }

    @DeleteMapping("/{id}")
    public Result<Void> deleteLedger(@PathVariable Integer id) { return null; }

    @GetMapping
    public Result<?> listUserLedgers() { return null; }

    @GetMapping("/{id}/members")
    public Result<?> getMembers(@PathVariable Integer id) { return null; }
}
