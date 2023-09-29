package com.example.springstarter.repository;

import com.example.springstarter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //    @Query(value = "SELECT * FROM users u JOIN company c ON u.compnai_id = c.id WHERE c.name = :name",
//            nativeQuery = true)
    @Query("select u from User u join u.company c where c.name = :name")
    public List<User> findAllByCompanyName(String name);

    Optional<UserDetails> findByUsername(String username);
}
