package com.spacebetween.linket.service;

import com.spacebetween.linket.domain.Users;
import com.spacebetween.linket.dto.users.UserPhoneUpdateDto;
import com.spacebetween.linket.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    /**
     * 이메일로 회원조회
     */
    public Users findByUserEmail(String email){
        return usersRepository.findByEmail(email);
    }

    /**
     * 전화번호 수정
     */
    @Transactional
    public void updateUserPhone(String email, UserPhoneUpdateDto userPhoneUpdateDto){
        Users user = usersRepository.findByEmail(email);
        user.setPhone(userPhoneUpdateDto.getPhone());
    }

//    public Users getUserByEmailAndPassword(String email, String password){
//        return usersRepository.findByEmailAndPassword(email,password);
//    }

    public void updateUserPassword(String email, String password){
        Users user = usersRepository.findByEmail(email);
        user.setPassword(password);
        usersRepository.save(user);
    }
}
