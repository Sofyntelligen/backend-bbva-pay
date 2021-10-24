package com.sofyntelligen.school.control.api.services;

import com.sofyntelligen.school.control.api.model.entity.Operation;
import com.sofyntelligen.school.control.api.repositories.OperationReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServices {

    @Autowired
    private OperationReposotory operationReposotory;
    
    public Operation operationSaveAndUpdate(Operation operation) {
        return this.operationReposotory.save(operation);
    }
}
