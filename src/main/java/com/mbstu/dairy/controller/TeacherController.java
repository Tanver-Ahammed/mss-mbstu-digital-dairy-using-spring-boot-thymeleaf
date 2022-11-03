package com.mbstu.dairy.controller;

import com.mbstu.dairy.services.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeacherController {
    
    @Autowired
    private TeacherServiceImpl teacherService;
    
}
