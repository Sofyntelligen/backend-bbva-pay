package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.DetailtsOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsOperationRepository extends CrudRepository<DetailtsOperation, String>, GenericRepository<DetailtsOperation> {

    @Override
    DetailtsOperation save(DetailtsOperation detailtsOperation);

}
