package com.mbstu.dairy.controller;

import com.mbstu.dairy.dto.FacultyDTO;
import com.mbstu.dairy.services.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/faculty")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

    @GetMapping(path = "/add")
    public String addFaculty(Model model) {
        model.addAttribute("facultyDTO", new FacultyDTO());
        model.addAttribute("message", "");
        model.addAttribute("dangerMessage", "");
        return "faculty/add-faculty";
    }

    @PostMapping(path = "/save")
    public String saveFaculty(@Valid @ModelAttribute("facultyDTO") FacultyDTO facultyDTO,
                              BindingResult result) {
        this.facultyService.addFaculty(facultyDTO);
        return "redirect:/faculty/all";
    }

    @GetMapping(path = "/all")
    public String getAllFaculties(Model model) {
        model.addAttribute("facultyDTOS", this.facultyService.getAllFaculty());
        return "faculty/all-faculties";
    }

    @GetMapping(path = "/get/{facultyId}")
    public String getFacultyById(@PathVariable("facultyId") Long facultyId, Model model) {
        model.addAttribute("facultyDTO", this.facultyService.getFacultyById(facultyId));
        return "faculty/single-faculty";
    }


}
