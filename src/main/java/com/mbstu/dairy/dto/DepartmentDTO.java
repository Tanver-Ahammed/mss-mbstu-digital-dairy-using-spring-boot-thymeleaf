package com.mbstu.dairy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

    private long id;

    private String name;

    private short startingYear;

    private String description;

    private FacultyDTO faculty;

    private List<TeacherDTO> teacherDTOS = new ArrayList<>();

}
