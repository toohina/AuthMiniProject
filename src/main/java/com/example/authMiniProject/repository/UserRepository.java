package com.example.authMiniProject.repository;

import com.example.authMiniProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); //findById is inbuilt but not findByUsername so we gotto make
}
