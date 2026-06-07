package me.spring.controller;

import me.spring.service.MailService;
import me.spring.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/test")
    public Result<Void> sendTestMail(@RequestBody Object request) {
        return null; // TODO: implement (dev/test only)
    }
}
