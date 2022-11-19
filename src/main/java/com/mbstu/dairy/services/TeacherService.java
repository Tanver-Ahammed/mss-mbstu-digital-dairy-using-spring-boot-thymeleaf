package com.mbstu.dairy.services;

import com.mbstu.dairy.dto.TeacherDTO;
import com.mbstu.dairy.entities.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TeacherService {

    // add teacher
    TeacherDTO addTeacher(TeacherDTO teacherDTO, MultipartFile teacherImage, Long departmentId) throws IOException;

    // get teacher by id
    TeacherDTO getSingleTeacherById(Long teacherId);

    // get all teacher
    List<TeacherDTO> getAllTeacher();

    List<TeacherDTO> getAllTeacherByDepartment(Long departmentId);

    TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO);
    // update teacher
    // delete teacher

    boolean deleteTeacher(Long teacherId);
}
