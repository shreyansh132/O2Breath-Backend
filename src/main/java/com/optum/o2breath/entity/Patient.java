package com.optum.o2breath.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientID;

    @Column(name = "full_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "age")
    private LocalDateTime dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "gender")
    private String gender;

    @Column(name = "gender")
    private Set<String> symptoms;

    @Column(name = "gender")
    private List<String> comorbidities;

    @Column(name = "gender")
    private String severity;

    @Column(name = "gender")
    private String latitude;

    @Column(name = "gender")
    private String longitude;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Set<Address> addresses;

}
