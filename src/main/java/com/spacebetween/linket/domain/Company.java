package com.spacebetween.linket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id; // 기업 아이디 (난수로 생성하여 추가, Staff 가입시 입력해야하는 값)
    private String companyName; // 기업명
    private String regDate; // 등록일자
    private String deletedDate; // 삭제일자
}
