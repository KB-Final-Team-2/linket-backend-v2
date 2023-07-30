package com.spacebetween.linket.repository;

import com.spacebetween.linket.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
    Users findByEmailAndPassword(String email, String password);
}
