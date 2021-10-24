package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationReposotory extends CrudRepository<Operation, String>, GenericRepository<Operation> {

    @Override
    Operation save(Operation matter);

}