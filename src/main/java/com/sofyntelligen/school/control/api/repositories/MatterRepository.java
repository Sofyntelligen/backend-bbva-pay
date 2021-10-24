package com.sofyntelligen.school.control.api.repositories;

import com.sofyntelligen.school.control.api.model.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatterRepository extends CrudRepository<Card, String>, GenericRepository<Card> {


}
