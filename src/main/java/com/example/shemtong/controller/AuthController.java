package com.example.shemtong.controller;

import com.example.shemtong.user.dto.EmailRequest;
import com.example.shemtong.user.dto.signup.SignupRequest;
import com.example.shemtong.user.jwt.JwtUtil;
import com.example.shemtong.user.service.AuthService;
import com.example.shemtong.user.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private MailService mailService;
    private String verificationCode;
    private JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil, MailService mailService) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.mailService = mailService;
    }

    @GetMapping("/checkusername")
    public ResponseEntity<?> checkUsername(@RequestParam("username") String username) {
        return authService.checkUsername(username);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> joinUser(@RequestBody SignupRequest signupRequest) {
        return authService.joinUser(signupRequest);
    }

    @PostMapping("/sendmail")
    public ResponseEntity<?> sendMail(@RequestParam("email") String email) throws MessagingException {
        return mailService.sendMail(email);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody EmailRequest emailRequest) {
        return mailService.verify(emailRequest);
    }

/*
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshUser(@RequestHeader("Authorization") String refreshToken) {
        String token = refreshToken.substring(7);

        if(jwtUtil.isTokenValid(token)) {
            return authService.refreshUser(token);
        }else{
            return ResponseEntity.status(401).body(new ErrorResponse("토큰을 찾을수 없습니다.", "토큰 유효성 오류"));
        }
    }
*/

}
