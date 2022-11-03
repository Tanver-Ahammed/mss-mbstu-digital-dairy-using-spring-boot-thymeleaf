package com.mbstu.dairy.services.impl;

import com.mbstu.dairy.dto.TeacherDTO;
import com.mbstu.dairy.entities.Teacher;
import com.mbstu.dairy.exceptions.ResourceNotFoundException;
import com.mbstu.dairy.repositories.TeacherRepository;
import com.mbstu.dairy.services.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO, MultipartFile teacherImage) {
        if (teacherImage != null) {

        }
        return null;
    }

    @Override
    public TeacherDTO getSingleTeacherById(Long teacherId) {
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeacher() {
        return null;
    }

    @Override
    public TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO) {
        return null;
    }

    @Override
    public boolean deleteTeacher(Long teacherId) {
        return false;
    }

    // get teacher by id
    public Teacher getTeacherById(Long teacherId) {
        return this.teacherRepository.findById(teacherId).orElseThrow(() ->
                new ResourceNotFoundException("Teacher", "id", teacherId));
    }

    // teacher to DTO
    public TeacherDTO teacherToDTO(Teacher teacher) {
        return this.modelMapper.map(teacher, TeacherDTO.class);
    }

    // dto to teacher
    public Teacher dtoToTeacher(TeacherDTO teacherDTO) {
        return this.modelMapper.map(teacherDTO, Teacher.class);
    }

}
