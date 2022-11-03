package com.mbstu.dairy.services.impl;

import com.mbstu.dairy.dto.FacultyDTO;
import com.mbstu.dairy.entities.Faculty;
import com.mbstu.dairy.exceptions.ResourceNotFoundException;
import com.mbstu.dairy.repositories.FacultyRepository;
import com.mbstu.dairy.services.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {
        return this.facultyToDTO(this.facultyRepository.save(this.dtoToFaculty(facultyDTO)));
    }

    @Override
    public FacultyDTO getSingleFacultyById(Long facultyId) {
        return this.facultyToDTO(this.getFacultyById(facultyId));
    }

    @Override
    public List<FacultyDTO> getAllFaculty() {
        return this.facultyRepository
                .findAll()
                .stream()
                .map(this::facultyToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO updateFaculty(Long facultyId, FacultyDTO facultyDTO) {
        Faculty faculty = this.getFacultyById(facultyId);
        faculty.setName(facultyDTO.getName());
        faculty.setStartingYear(facultyDTO.getStartingYear());
        faculty.setDescription(facultyDTO.getDescription());
        return this.facultyToDTO(this.facultyRepository.save(faculty));
    }

    @Override
    public boolean deleteFaculty(Long facultyId) {
        Faculty faculty = this.getFacultyById(facultyId);
        this.facultyRepository.delete(faculty);
        return true;
    }

    // get faculty by id
    public Faculty getFacultyById(Long facultyId) {
        return this.facultyRepository.findById(facultyId).orElseThrow(() ->
                new ResourceNotFoundException("Faculty", "id", facultyId));
    }

    // faculty to DTO
    public FacultyDTO facultyToDTO(Faculty faculty) {
        return this.modelMapper.map(faculty, FacultyDTO.class);
    }

    // dto to faculty
    public Faculty dtoToFaculty(FacultyDTO facultyDTO) {
        return this.modelMapper.map(facultyDTO, Faculty.class);
    }

}
