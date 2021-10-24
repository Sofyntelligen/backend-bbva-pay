package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.Operation;
import com.bbva.shopping.pay.api.services.MapValidationErrorService;
import com.bbva.shopping.pay.api.services.OperationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pay")
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationServices operationServices;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/")
    public ResponseEntity<?> createOperation(@Valid @RequestBody Operation operation, BindingResult bindingResult) {

        System.out.println("\n" + operation.toString());
        
        ResponseEntity<?> responseEntity = this.mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {

            //Operation resultOperation = this.operationServices.operationSaveAndUpdate(operation);
            //responseEntity = new ResponseEntity<>(resultOperation, HttpStatus.CREATED);

        }

        return responseEntity;
    }
}
