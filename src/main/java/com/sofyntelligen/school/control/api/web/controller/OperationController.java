package com.sofyntelligen.school.control.api.web.controller;

import com.sofyntelligen.school.control.api.model.entity.Operation;
import com.sofyntelligen.school.control.api.services.MapValidationErrorService;
import com.sofyntelligen.school.control.api.services.OperationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationServices operationServices;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/")
    public ResponseEntity<?> createMatter(@Valid @RequestBody Operation operation, BindingResult bindingResult) {

        System.out.println(operation.toString());
        
        ResponseEntity<?> responseEntity = this.mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {

            Operation resultOperation = this.operationServices.operationSaveAndUpdate(operation);
            responseEntity = new ResponseEntity<>(resultOperation, HttpStatus.CREATED);

        }

        return responseEntity;
    }
}
