package com.spacebetween.linket.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String email; // 이메일

    @Column(nullable = false, length = 100)
    private String password; // 비밀번호

    @Column(nullable = false, length = 20)
    private String userName; // 이름

    @Column(nullable = false)
    private String birthdate; // 생년월일

    @Column(nullable = false)
    private boolean agreement; // 개인정보동의

    @Column(nullable = false)
    private String phone; // 전화번호

    @Column(nullable = false)
    private char gender; // 성별

    @Column(nullable = false)
    private String role; // 회원 권한

    private LocalDateTime withdrawDate; // 회원탈퇴일자

    @Column
    private char enabled; // 회원탈퇴여부

    @CreatedDate
    @Column(updatable = false)
    @DateTimeFormat
    private LocalDateTime regDate; // 등록일자

    @LastModifiedDate
    private LocalDateTime lastUpdatedDate; // 수정일자

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "users")
    private List<Attendance> attendances = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Ticket> tickets = new ArrayList<>();

}
