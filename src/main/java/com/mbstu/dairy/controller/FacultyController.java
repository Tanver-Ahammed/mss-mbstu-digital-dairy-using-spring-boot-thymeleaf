package com.mbstu.dairy.controller;

import com.mbstu.dairy.services.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FacultyController {
    
    @Autowired
    private FacultyServiceImpl facultyService;
    
}
