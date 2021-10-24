package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.Company;
import com.bbva.shopping.pay.api.model.entity.Token;
import com.bbva.shopping.pay.api.model.entity.User;
import com.bbva.shopping.pay.api.services.CompanyServices;
import com.bbva.shopping.pay.api.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyServices companyServices;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/")
    public ResponseEntity<?> createCompany(@Valid @RequestBody Company company, BindingResult bindingResult) {

        System.out.println("\n" + company.toString());

        company.setActive(Boolean.TRUE);
        ResponseEntity<?> responseEntity = this.mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {
            Company resultCompany = this.companyServices.companySaveAndUpdate(company);
            responseEntity = new ResponseEntity<>(new Token(resultCompany.getId()), HttpStatus.CREATED);
        } else {
            responseEntity = new ResponseEntity<>("", HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getCompanis() {

        Iterable<Company> userOptional = this.companyServices.findAll();
        return new ResponseEntity(userOptional, HttpStatus.OK);

    }
    
}
