package com.app.doubtconnect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.doubtconnect.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserID(Integer userID);
}
