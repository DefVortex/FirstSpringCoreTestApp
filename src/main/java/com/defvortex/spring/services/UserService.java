package com.defvortex.spring.services;

import com.defvortex.spring.entitys.User;
import com.defvortex.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    public List<User> getListOfUsers() {
        return userRepository.getListOfUsers();
    }
}
