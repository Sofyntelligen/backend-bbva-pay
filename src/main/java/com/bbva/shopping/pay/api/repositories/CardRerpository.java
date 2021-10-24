package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.Card;
import com.bbva.shopping.pay.api.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRerpository extends CrudRepository<Card, String>, GenericRepository<Card> {

    @Override
    Card save(Card card);

    List<Card> findAllByUser(User user);

}
