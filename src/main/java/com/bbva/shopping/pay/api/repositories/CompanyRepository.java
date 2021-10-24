package com.bbva.shopping.pay.api.repositories;

import com.bbva.shopping.pay.api.model.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String>, GenericRepository<Company> {

    @Override
    Company save(Company company);

}
