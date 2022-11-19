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
public class TeacherDTO {

    private Long id;

    private String name;

    private String contact;

    private String email;

    private int dateOfBirth;

    private String bloodGroup;

    private String address;

    private String designation;

    private String maritalStatus;

    private String joinedDate;

    private boolean activityStatus;

    private String image;

    private DepartmentDTO departmentDTO;

}
