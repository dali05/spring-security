package com.example.security.repository;

import com.example.security.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @EntityGraph(attributePaths = {"authorities"})
    Optional<User> findUserByUsername(String username);
}
