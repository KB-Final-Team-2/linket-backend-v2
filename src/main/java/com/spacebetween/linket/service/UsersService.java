package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public Users getUserByEmailAndPassword(String email, String password){
        return usersRepository.findByEmailAndPassword(email,password);
    }

    public void updateUserPhone(String email, String phone){
        Users user = usersRepository.findByEmail(email);
        user.setPhone(phone);
        usersRepository.save(user);
    }

    public void updateUserPassword(String email, String password){
        Users user = usersRepository.findByEmail(email);
        user.setPassword(password);
        usersRepository.save(user);
    }
}
