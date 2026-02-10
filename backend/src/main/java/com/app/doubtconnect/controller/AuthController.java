package com.app.doubtconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doubtconnect.dto.LoginDTO;
import com.app.doubtconnect.security.JwtService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    // @Autowired
    // private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    @Async
    public String login(@RequestBody LoginDTO payload, HttpServletResponse response) {
        System.out.println(payload.getUsername() + " " + payload.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));

        System.out.println("Yoyoyoyoy");
        if (authentication.isAuthenticated()) {
            System.out.println("Authenticated");
            // return jwtService.generateToken(payload.getUsername());
            String jwtToken = jwtService.generateToken(payload.getUsername());
            Cookie cookie = new Cookie("jwt", jwtToken);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(1 * 24 * 60 * 60);
            response.addCookie(cookie);
            return "Login Sucessful";
        } else {
            System.out.println("Unauthenticated");
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        System.out.println("Logged out Successfully");
        return ResponseEntity.ok("Logged out successfully");
    }


}