package com.mbstu.dairy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacultyDTO {

    private long id;

    private String name;

    private short startingYear;

    private String description;

    private List<DepartmentDTO> departmentDTOS = new ArrayList<>();

}
