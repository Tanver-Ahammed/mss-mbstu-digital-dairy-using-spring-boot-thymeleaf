package com.mbstu.dairy.controller;

import com.mbstu.dairy.dto.TeacherDTO;
import com.mbstu.dairy.services.impl.DepartmentServiceImpl;
import com.mbstu.dairy.services.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping(path = "/add/{departmentId}")
    public String addTeacher(@PathVariable("departmentId") Long departmentId, Model model) {
        model.addAttribute("teacherDTO", new TeacherDTO());
        model.addAttribute("message", "");
        model.addAttribute("dangerMessage", "");
        model.addAttribute("departmentId", departmentId);
        return "teacher/add-teacher";
    }

    @PostMapping(path = "/save/{departmentId}")
    public String saveTeacher(@Valid @ModelAttribute("teacherDTO") TeacherDTO teacherDTODTO,
                              @RequestParam("teacherImage") MultipartFile teacherImage,
                              @PathVariable("departmentId") Long departmentId,
                              BindingResult result) throws IOException {
        this.teacherService.addTeacher(teacherDTODTO, teacherImage, departmentId);
        return "redirect:/teacher/all/by/department/" + departmentId;
    }

    @GetMapping(path = "/all")
    public String getAllTeachers(Model model) {
        model.addAttribute("teacherDTOS", this.teacherService.getAllTeacher());
        return "teacher/all-teachers";
    }

    @GetMapping(path = "/all/by/department/{departmentId}")
    public String getAllTeachersByDepartment(@PathVariable("departmentId") Long departmentId, Model model) {
        model.addAttribute("teacherDTOS", this.teacherService.getAllTeacherByDepartment(departmentId));
        return "teacher/all-teachers";
    }

    @GetMapping(path = "/get/{teacherId}")
    public String geTeacherIddById(@PathVariable("teacherId") Long teacherId, Model model) {
        model.addAttribute("teacherDTO", this.teacherService.getTeacherById(teacherId));
        return "teacher/single-teacher";
    }

}
