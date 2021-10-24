package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
    
}
