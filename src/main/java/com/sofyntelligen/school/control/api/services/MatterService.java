package com.sofyntelligen.school.control.api.services;

import com.sofyntelligen.school.control.api.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MatterService {

    @Autowired
    private MatterRepository matterRepository;

   

}
