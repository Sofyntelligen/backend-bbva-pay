package com.sofyntelligen.school.control.api.web.controller;

import com.sofyntelligen.school.control.api.services.MapValidationErrorService;
import com.sofyntelligen.school.control.api.services.MatterService;
import com.sofyntelligen.school.control.api.util.Util;
import com.sofyntelligen.school.control.api.web.exception.MyResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matter")
@CrossOrigin
public class MatterController {

    @Autowired
    private MatterService matterService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    
}
