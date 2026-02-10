package com.app.doubtconnect.controller;


import com.app.doubtconnect.dto.DoubtDTO;
import com.app.doubtconnect.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doubt")
public class DoubtController {

    @Autowired
    private DoubtService doubtService;

    @PostMapping("/post")
    public ResponseEntity<?> postDoubt(@RequestBody DoubtDTO payload) throws Exception {
        return doubtService.postDoubt(payload);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDoubt(@PathVariable Long id) {
        return doubtService.getDoubt(id);
    }


    @GetMapping("/feed")
    public ResponseEntity<?> getDoubtFeed() {
        return doubtService.getFeed();
    }

    @GetMapping("/myDoubts")
    public ResponseEntity<?> getMyDoubts() {
        return doubtService.getMyDoubts();
    }
}
