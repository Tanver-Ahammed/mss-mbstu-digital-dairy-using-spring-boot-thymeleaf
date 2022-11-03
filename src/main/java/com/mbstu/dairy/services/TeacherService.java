package com.mbstu.dairy.services;

import com.mbstu.dairy.dto.TeacherDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherService {

    // add teacher
    TeacherDTO addTeacher(TeacherDTO teacherDTO, MultipartFile teacherImage);

    // get teacher by id
    TeacherDTO getSingleTeacherById(Long teacherId);

    // get all teacher
    List<TeacherDTO> getAllTeacher();

    // update teacher
    TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO);

    // delete teacher
    boolean deleteTeacher(Long teacherId);

}
