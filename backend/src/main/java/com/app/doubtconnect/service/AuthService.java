package com.app.doubtconnect.service;


import com.app.doubtconnect.dto.LoginDTO;
import com.app.doubtconnect.dto.SignupDTO;
import com.app.doubtconnect.model.User;
import com.app.doubtconnect.repository.UserRepository;
import com.app.doubtconnect.security.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> signup(SignupDTO payload) {
        if (userRepository.findByEmail(payload.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body("User already exists with this email");
        }

        User user = new User();
        user.setEmail(payload.getEmail());
        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        log.info("New user registered: {}", payload.getEmail());

        return ResponseEntity.ok("Signup successful");
    }

    public ResponseEntity<?> login(LoginDTO payload, HttpServletResponse response) {
        System.out.println(payload);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword()));

        if (authentication.isAuthenticated()) {
            System.out.println("Authenticated");
            String jwtToken = jwtService.generateToken(payload.getUsername());
            Cookie cookie = new Cookie("jwt", jwtToken);
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            cookie.setMaxAge(1 * 24 * 60 * 60);
            response.addCookie(cookie);
            return ResponseEntity.ok("Login Sucessful");
        } else {
            System.out.println("Unauthenticated");
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

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
