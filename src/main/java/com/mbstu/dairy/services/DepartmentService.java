package com.mbstu.dairy.services;

import com.mbstu.dairy.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    // add department
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO, Long facultyId);

    // get department by id
    DepartmentDTO getSingleDepartmentById(Long departmentId);

    // get all department
    List<DepartmentDTO> getAllDepartment();

    List<DepartmentDTO> getAllDepartmentByFaculty(Long facultyId);

    // update department
    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);

    // delete department
    boolean deleteDepartment(Long departmentId);

}
