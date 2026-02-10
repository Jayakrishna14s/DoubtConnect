package com.app.doubtconnect.controller;


import com.app.doubtconnect.dto.DoubtDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doubt")
public class DoubtController {

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody DoubtDTO payload) {
        return ResponseEntity.ok(null);
    }
}
