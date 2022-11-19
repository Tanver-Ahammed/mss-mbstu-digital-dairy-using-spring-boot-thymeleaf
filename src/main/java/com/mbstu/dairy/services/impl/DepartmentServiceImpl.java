package com.mbstu.dairy.services.impl;

import com.mbstu.dairy.dto.DepartmentDTO;
import com.mbstu.dairy.entities.Department;
import com.mbstu.dairy.entities.Faculty;
import com.mbstu.dairy.exceptions.ResourceNotFoundException;
import com.mbstu.dairy.repositories.DepartmentRepository;
import com.mbstu.dairy.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyServiceImpl facultyService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO, Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        Department department = this.dtoToDepartment(departmentDTO);
        department.setFaculty(faculty);
        return this.departmentToDTO(this.departmentRepository.save(department));
    }

    @Override
    public DepartmentDTO getSingleDepartmentById(Long departmentId) {
        return this.departmentToDTO(this.getDepartmentById(departmentId));
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        return this.departmentRepository.findAll().stream()
                .map(this::departmentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DepartmentDTO> getAllDepartmentByFaculty(Long facultyId) {
        Faculty faculty = this.facultyService.getFacultyById(facultyId);
        return this.departmentRepository
                .findDepartmentByFaculty(faculty)
                .stream()
                .map(this::departmentToDTO).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department department = this.getDepartmentById(departmentId);
        department.setName(departmentDTO.getName());
        department.setStartingYear(departmentDTO.getStartingYear());
        department.setDescription(department.getDescription());
        department.setFaculty(this.facultyService.dtoToFaculty(departmentDTO.getFaculty()));
        return this.departmentToDTO(this.departmentRepository.save(department));
    }

    @Override
    public boolean deleteDepartment(Long departmentId) {
        this.departmentRepository.delete(this.getDepartmentById(departmentId));
        return true;
    }

    // get department by id
    public Department getDepartmentById(Long departmentId) {
        return this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "id", departmentId));
    }

    // department to DTO
    public DepartmentDTO departmentToDTO(Department department) {
        return this.modelMapper.map(department, DepartmentDTO.class);
    }

    // dto to department
    public Department dtoToDepartment(DepartmentDTO departmentDTO) {
        return this.modelMapper.map(departmentDTO, Department.class);
    }

}
