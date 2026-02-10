package com.app.doubtconnect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.doubtconnect.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserID(Long userID);
    Optional<User> findByEmail(String email);
}
