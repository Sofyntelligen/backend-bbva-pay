package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.UserAccess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessRepository extends CrudRepository<UserAccess, String>, GenericRepository<UserAccess> {

    @Override
    UserAccess save(UserAccess userAccess);
    
    Optional<UserAccess> findByUsernameEqualsAndPasswordEquals(String username, String password);

}