package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.Company;
import com.bbva.shopping.pay.api.services.CompanyServices;
import com.bbva.shopping.pay.api.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
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

        ResponseEntity<?> responseEntity = this.mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {

            //Operation resultOperation = this.operationServices.operationSaveAndUpdate(operation);
            //responseEntity = new ResponseEntity<>(resultOperation, HttpStatus.CREATED);

        }

        return responseEntity;
    }
}
