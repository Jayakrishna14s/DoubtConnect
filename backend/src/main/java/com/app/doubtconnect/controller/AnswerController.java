package com.app.doubtconnect.controller;


import com.app.doubtconnect.dto.AnswerDTO;
import com.app.doubtconnect.model.Answer;
import com.app.doubtconnect.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/comment")
    public ResponseEntity<?> postComment(AnswerDTO payload) {
        return null;
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<?> getComment(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/cpmment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody AnswerDTO payload) {
        return null;
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getComments() {
        return null;
    }

}
