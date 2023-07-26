package com.spacebetween.linket.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String birthdate;

    @Column(nullable = false)
    private boolean agreement;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private String role;

    private LocalDateTime reg_date;

    private LocalDateTime withdraw_date;

    @Column
    private char enabled;

//    @OneToMany
//    @JoinColumn(name="user_company_id")
//    private Company company;

    private LocalDateTime lastUpdatedDate;
}
