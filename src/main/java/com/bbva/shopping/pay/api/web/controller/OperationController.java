package com.bbva.shopping.pay.api.web.controller;

import com.bbva.shopping.pay.api.model.entity.*;
import com.bbva.shopping.pay.api.services.DetailsOperationServices;
import com.bbva.shopping.pay.api.services.MapValidationErrorService;
import com.bbva.shopping.pay.api.services.OperationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pay")
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationServices operationServices;

    @Autowired
    private DetailsOperationServices detailsOperationServices;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/")
    public ResponseEntity<?> createOperation(@Valid @RequestBody Operation operation, BindingResult bindingResult) {
        
        ResponseEntity<?> responseEntity = this.mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {
            
            System.out.println(operation.toString());
            
            operation.setTransaction(UUID.randomUUID().toString());
            Operation resultOperation = this.operationServices.operationSaveAndUpdate(operation);
            
            for (DetailtsOperation detailtsOperation : operation.getOperation()) {
                detailtsOperation.setOperation(resultOperation);
                this.detailsOperationServices.detailtsOperationSaveAndUpdate(detailtsOperation);
            }
            
            responseEntity = new ResponseEntity<>(new Token(resultOperation.getId()), HttpStatus.CREATED);

        }

        return responseEntity;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<?>  getOperation(@PathVariable("id") String id) {

        Optional<Operation> operationOptional = this.operationServices.findById(id);
        ResponseEntity<?> responseEntity = null;

        if (operationOptional.isPresent()) {
            responseEntity = new ResponseEntity(operationOptional.get(), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity("Operation with not exist.", HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }
}
