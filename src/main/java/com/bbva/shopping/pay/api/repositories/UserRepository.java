package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>, GenericRepository<User> {

    @Override
    User save(User user);

}