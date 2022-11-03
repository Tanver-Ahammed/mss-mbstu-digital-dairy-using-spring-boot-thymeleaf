package com.mbstu.dairy.controller;

import com.mbstu.dairy.services.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DepartmentController {
    
    @Autowired
    private DepartmentServiceImpl departmentService;

    
}
