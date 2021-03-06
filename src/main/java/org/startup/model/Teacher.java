package org.startup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.startup.utils.ErrorMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Abdullah Al Amin on 9/15/2018.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotBlank(message = ErrorMessage.NAME_BLANK)
    private String name;

    @NotBlank(message = ErrorMessage.MOBILE_BLANK)
    @Column(unique = true)
    private String mobile;

    @NotBlank(message = ErrorMessage.EMAIL_BLANK)
    @Column(unique = true)
    private String email;

    private String gender;

    @NotBlank(message = ErrorMessage.UNI_BLANK)
    private String university;

    @NotBlank(message = ErrorMessage.DEPT_BLANK)
    private String department;


    @Column(name = "preferred_location")
    @JsonProperty("preferred_location")
    private HashSet<String> preferredLocation;

    @Column(name = "expected_salary_min")
    @JsonProperty("expected_salary_min")
    private short expectedSalaryMin;

    @Column(name = "expected_salary_max")
    @JsonProperty("expected_salary_max")
    private short expectedSalaryMax;

    @Column(name = "admin_approval")
    @JsonProperty("admin_approval")
    private boolean approvedByAdmin;

    @OneToOne
    @JoinColumn(name = "fileData_id")
    private FileData fileData;




}
