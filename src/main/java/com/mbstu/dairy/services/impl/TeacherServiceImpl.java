package com.mbstu.dairy.services.impl;

import com.mbstu.dairy.dto.TeacherDTO;
import com.mbstu.dairy.entities.Department;
import com.mbstu.dairy.entities.Teacher;
import com.mbstu.dairy.exceptions.ResourceNotFoundException;
import com.mbstu.dairy.repositories.TeacherRepository;
import com.mbstu.dairy.services.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    @Override
    public TeacherDTO addTeacher(TeacherDTO teacherDTO, MultipartFile teacherImage, Long departmentId) throws IOException {
        if (teacherImage != null) {
            String alumniImageName = this.fileService.uploadImage(path, teacherImage);
            teacherDTO.setImage(alumniImageName);
        }
        Department department = this.departmentService.getDepartmentById(departmentId);
        Teacher teacher = this.dtoToTeacher(teacherDTO);
        teacher.setDepartment(department);
        teacher.setActivityStatus(true);
        return this.teacherToDTO(this.teacherRepository.save(teacher));
    }

    @Override
    public TeacherDTO getSingleTeacherById(Long teacherId) {
        return this.teacherToDTO(this.getTeacherById(teacherId));
    }

    @Override
    public List<TeacherDTO> getAllTeacher() {
        return this.teacherRepository
                .findAll()
                .stream()
                .map(this::teacherToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeacherDTO> getAllTeacherByDepartment(Long departmentId) {
        Department department = this.departmentService.getDepartmentById(departmentId);
        return this.teacherRepository
                .findTeacherByDepartment(department)
                .stream()
                .map(this::teacherToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO updateTeacher(Long teacherId, TeacherDTO teacherDTO) {
        Teacher teacher = this.getTeacherById(teacherId);
        teacher.setName(teacherDTO.getName());
        teacher.setContact(teacherDTO.getContact());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setBloodGroup(teacherDTO.getBloodGroup());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setDesignation(teacherDTO.getDesignation());
        teacher.setMaritalStatus(teacherDTO.getMaritalStatus());
        return this.teacherToDTO(teacher);
    }

    @Override
    public boolean deleteTeacher(Long teacherId) {
        Teacher teacher = this.getTeacherById(teacherId);
        this.teacherRepository.delete(teacher);
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
