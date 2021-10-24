package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.Operation;
import com.bbva.shopping.pay.api.repositories.OperationReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationServices {

    @Autowired
    private OperationReposotory operationReposotory;
    
    public Operation operationSaveAndUpdate(Operation operation) {
        return this.operationReposotory.save(operation);
    }

    public Optional<Operation> findById(String id) {
        return this.operationReposotory.findById(id);
    }

}
