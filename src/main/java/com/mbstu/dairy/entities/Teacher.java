package com.mbstu.dairy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "department_id_fk", referencedColumnName = "id")
    private Department department;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attachment> attachments = new ArrayList<>();

}
