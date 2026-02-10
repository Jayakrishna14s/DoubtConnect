package com.app.doubtconnect.service;


import com.app.doubtconnect.dto.DoubtDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubtService {

    public ResponseEntity<?> post(DoubtDTO payload) {
        return  null;
    }

    public ResponseEntity<?> postAll(List<DoubtDTO> doubts) {
        return null;
    }

    public ResponseEntity<?> delete(Long doubtId) {
        return null;
    }

    public ResponseEntity<?> update(Long doubtId, DoubtDTO payload) {
        return null;
    }

    public ResponseEntity<?> get(Long doubtId) {
        return null;
    }

    public ResponseEntity<?> getAll() {
        return null;
    }
}
