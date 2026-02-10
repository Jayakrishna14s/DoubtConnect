package com.app.doubtconnect.service;


import com.app.doubtconnect.dto.DoubtDTO;
import com.app.doubtconnect.model.Doubt;
import com.app.doubtconnect.model.User;
import com.app.doubtconnect.repository.DoubtRepository;
import com.app.doubtconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoubtService {

    @Autowired
    private DoubtRepository doubtRepository;
    @Autowired
    private UserRepository userRepository;

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public ResponseEntity<?> postDoubt(DoubtDTO payload) throws Exception {
        String username = getUsername();

        Doubt doubt = new Doubt();
        doubt.setTitle(payload.getTitle());
        doubt.setDescription(payload.getDescription());


        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            throw new Exception("Unauthenticated User");
        }

        doubt.setUser(user.get());
        return ResponseEntity.ok(doubtRepository.save(doubt));
    }



    public ResponseEntity<?> getDoubt(Long doubtId) {
        Optional<Doubt> doubt = doubtRepository.findById(doubtId);

        if (doubt.isPresent()) {
            System.out.println(doubt.get());
            System.out.println(doubtId);
            return ResponseEntity.ok(doubt.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<?> getFeed() {
        String username = getUsername();
        List<Doubt> feed = doubtRepository.findByUserUsernameNot(username);
        return ResponseEntity.ok(feed);
    }

    public ResponseEntity<?> getMyDoubts() {
        String username = getUsername();
        List<Doubt> myDoubts = doubtRepository.findByUserUsername(username);
        if(myDoubts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(myDoubts);
    }
}
