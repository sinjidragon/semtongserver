package com.example.shemtong.domain.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Operation(summary = "permitall 권한")
    @GetMapping("permitAll")
    public String permitAllApi() {
        return "permitAllApi";
    }

    @Operation(summary = "authenticated 권한")
    @GetMapping("authenticated")
    public String authenticatedApi() {
        return "authenticatedApi";
    }

    @Operation(summary = "admin 권한")
    @GetMapping("admin")
    public String adminApi() {
        return "adminApi";
    }

}
