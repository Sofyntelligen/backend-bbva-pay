package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.Card;
import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.services.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin
public class CardController {

    @Autowired
    private CardServices cardServices;
    
    @GetMapping(path="/{id}")
    public ResponseEntity<?>  getCards(@PathVariable("id") String id) {
       
        User user = new User();
        user.setId(id);

        List<Card> listUserResult = this.cardServices.findAllByUser(user);
        return new ResponseEntity(listUserResult, HttpStatus.OK);
        
    }

}
