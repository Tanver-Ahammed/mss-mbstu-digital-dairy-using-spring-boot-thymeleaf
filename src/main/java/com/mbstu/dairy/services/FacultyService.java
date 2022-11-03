package com.mbstu.dairy.services;

import com.mbstu.dairy.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    // add faculty
    FacultyDTO addFaculty(FacultyDTO facultyDTO);

    // get faculty by id
    FacultyDTO getSingleFacultyById(Long facultyId);

    // get all faculty
    List<FacultyDTO> getAllFaculty();

    // update faculty
    FacultyDTO updateFaculty(Long facultyId, FacultyDTO facultyDTO);

    // delete faculty
    boolean deleteFaculty(Long facultyId);

}
