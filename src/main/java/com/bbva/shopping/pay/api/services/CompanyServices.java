package com.bbva.shopping.pay.api.services;

import com.bbva.shopping.pay.api.model.entity.Company;
import com.bbva.shopping.pay.api.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServices {

    @Autowired
    private CompanyRepository companyRepository;

    public Company companySaveAndUpdate(Company company) {
        return this.companyRepository.save(company);
    }

    public Iterable<Company> findAll() {
        return this.companyRepository.findAll();
    }


}
