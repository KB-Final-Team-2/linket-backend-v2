package com.spacebetween.linket.repository;

import com.spacebetween.linket.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * 회원 이메일로 본인정보조회
     */
    Users findByEmail(String email);

    Users findByEmailAndPassword(String email, String password);

    /**
     * 이메일 중복 체크
     */
    boolean existsByUserEmail(String email);

    Optional<Users> findByUserEmail(String email);
}
