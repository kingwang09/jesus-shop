package org.jesus.shop.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.user.entity.User;
import org.jesus.shop.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public User changeUserAge(Long id, int age){
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);//select쿼리가 무조건 나가게 된다.
        user.changeAge(age);
        return user;
    }

    @Transactional
    public User changeUserAge(User user, int age){
        user = userRepository.findById(user.getId()).orElseThrow(NoSuchElementException::new);//select쿼리가 무조건 나가게 된다.
        user.changeAge(age);
        return user;
    }

    public User add(User user){
        return userRepository.save(user);
    }
}
