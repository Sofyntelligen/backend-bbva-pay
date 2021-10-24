package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.UserAccess;
import com.bbva.shopping.pay.api.repositories.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccessServices {

    @Autowired
    private UserAccessRepository userAccessRepository;

    public Optional<UserAccess> findByUsernameAndPassword(String username, String password) {
        return this.userAccessRepository.findByUsernameAndPassword(username, password);
    }
}
