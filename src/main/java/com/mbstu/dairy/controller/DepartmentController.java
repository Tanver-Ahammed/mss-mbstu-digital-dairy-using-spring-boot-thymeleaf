package com.mbstu.dairy.controller;

import com.mbstu.dairy.dto.DepartmentDTO;
import com.mbstu.dairy.services.impl.DepartmentServiceImpl;
import com.mbstu.dairy.services.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private FacultyServiceImpl facultyService;

    @GetMapping(path = "/add/{facultyId}")
    public String addDepartment(@PathVariable("facultyId") Long facultyId, Model model) {
        model.addAttribute("departmentDTO", new DepartmentDTO());
        model.addAttribute("message", "");
        model.addAttribute("dangerMessage", "");
        model.addAttribute("facultyId", facultyId);
        return "department/add-department";
    }

    @PostMapping(path = "/save/{facultyId}")
    public String saveDepartment(@Valid @ModelAttribute("departmentDTO") DepartmentDTO departmentDTO,
                                 @PathVariable("facultyId") Long facultyId,
                                 BindingResult result) {
        this.departmentService.addDepartment(departmentDTO, facultyId);
        return "redirect:/department/all/by/faculty/" + facultyId;
    }

    @GetMapping(path = "/all")
    public String getAllDepartments(Model model) {
        model.addAttribute("departmentDTOS", this.departmentService.getAllDepartment());
        return "department/all-departments";
    }

    @GetMapping(path = "/all/by/faculty/{facultyId}")
    public String getAllDepartmentsByFaculty(@PathVariable("facultyId") Long facultyId, Model model) {
        model.addAttribute("departmentDTOS", this.departmentService.getAllDepartmentByFaculty(facultyId));
        return "department/all-departments";
    }

    @GetMapping(path = "/get/{departmentId}")
    public String getDepartmentIdById(@PathVariable("departmentId") Long departmentId, Model model) {
        model.addAttribute("departmentDTO", this.departmentService.getDepartmentById(departmentId));
        return "department/single-department";
    }

}
