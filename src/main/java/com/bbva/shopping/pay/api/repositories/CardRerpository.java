package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRerpository extends CrudRepository<Card, String>, GenericRepository<Card> {

    @Override
    Card save(Card card);

}
