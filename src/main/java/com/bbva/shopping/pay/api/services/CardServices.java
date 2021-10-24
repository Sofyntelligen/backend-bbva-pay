package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.Card;
import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.repositories.CardRerpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServices {

    @Autowired
    private CardRerpository cardRerpository;

    public List<Card> findAllByUser(User user) {
        return this.cardRerpository.findAllByUser(user);
    }
}