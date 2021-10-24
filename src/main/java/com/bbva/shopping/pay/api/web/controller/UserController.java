package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.Company;
import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.model.entity.UserAccess;
import com.bbva.shopping.pay.api.services.UserAccessServices;
import com.bbva.shopping.pay.api.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserAccessServices userAccessServices;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {

        Optional<User> userOptional = this.userServices.findById(id);
        ResponseEntity<?> responseEntity = null;

        if (userOptional.isPresent()) {
            responseEntity = new ResponseEntity(userOptional.get(), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Report with ID: '" + id + "' not exist.", HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @PatchMapping("/login/")
    public ResponseEntity<?> getAutenticationUser(@Valid @RequestBody UserAccess userAccess, BindingResult bindingResult) {
        
        Optional<UserAccess> userOptional =
                this.userAccessServices.findByUsernameAndPassword(userAccess.getUsername(), userAccess.getPassword());
        ResponseEntity<?> responseEntity = null;

        if (userOptional.isPresent()) {
            responseEntity = new ResponseEntity("OK", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Client with not exist.", HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }


}
