package org.startup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter@Setter
    private long id;

    @Getter
    @Setter
    @NotBlank(message = ErrorMessage.NAME_BLANK)
    private String name;

    @Getter@Setter
    @NotBlank(message = ErrorMessage.MOBILE_BLANK)
    @Column(unique = true)
    private String mobile;

    @Getter@Setter
    @NotBlank(message = ErrorMessage.EMAIL_BLANK)
    @Column(unique = true)
    private String email;

    @Getter@Setter
    private String gender;

    @Getter@Setter
    @NotBlank(message = ErrorMessage.UNI_BLANK)
    private String university;

    @Getter@Setter
    @NotBlank(message = ErrorMessage.DEPT_BLANK)
    private String department;


    @Getter@Setter
    @Column(name = "preferred_location")
    @JsonProperty("preferred_location")
    private HashSet<String> preferredLocation;

    @Getter@Setter
    @Column(name = "expected_salary_min")
    @JsonProperty("expected_salary_min")
    private short expectedSalaryMin;

    @Getter@Setter
    @Column(name = "expected_salary_max")
    @JsonProperty("expected_salary_max")
    private short expectedSalaryMax;

    @OneToOne
    @JoinColumn(name = "fileData_id")
    @Getter@Setter
    private FileData fileData;




}
