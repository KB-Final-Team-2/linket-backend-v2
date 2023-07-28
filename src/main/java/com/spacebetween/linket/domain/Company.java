package com.spacebetween.linket.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id; // 기업 아이디 (난수로 생성하여 추가, Staff 가입시 입력해야하는 값)

    private String companyName; // 기업명
    private String regDate; // 등록일자
    private String deletedDate; // 삭제일자

    @OneToMany(mappedBy = "company")
    private List<Users> users = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Event> events = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
