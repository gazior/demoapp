package com.example.demoapp.repository;

import com.example.demoapp.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    CustomUser findCustomUserByUsername(String username);
}
