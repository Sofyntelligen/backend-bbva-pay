package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.DetailtsOperation;
import com.bbva.shopping.pay.api.model.entity.Operation;
import com.bbva.shopping.pay.api.repositories.DetailsOperationRepository;
import com.bbva.shopping.pay.api.repositories.OperationReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsOperationServices {

    @Autowired
    private DetailsOperationRepository detailsOperationRepository;

    public DetailtsOperation detailtsOperationSaveAndUpdate(DetailtsOperation detailtsOperation) {
        return this.detailsOperationRepository.save(detailtsOperation);
    }

}