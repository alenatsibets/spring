package com.example.spring.repository;

import com.example.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    @Query("select u from User u where u.userName like %:pattern% or u.email like %:pattern%")
    List<User> findByPartOfUsernameOrEmail(String pattern);
    void deleteById(Long id);
    void deleteByEmail(String email);
    void delete(User user);
    User save(User user);
}