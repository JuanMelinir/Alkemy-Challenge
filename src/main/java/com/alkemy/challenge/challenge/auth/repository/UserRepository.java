package com.alkemy.challenge.challenge.auth.repository;

import com.alkemy.challenge.challenge.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
     User findByname (String username);
}
