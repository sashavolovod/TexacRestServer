package gefest.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "personnel_number", nullable = false)
    private Integer personnelNumber;

    @Column(name = "department", nullable = false)
    private Integer department;

    @Column(name = "team", length = 10)
    private String team;

    @Column(name = "first_name", nullable = false, length = 33)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "position_title")
    private Integer positionTitle;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "operation", length = 21)
    private String operation;

    @Column(name = "performed_operations", length = 90)
    private String performedOperations;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(name = "is_working")
    private Boolean isWorking;

    @Column(name = "category", nullable = false)
    private Integer category;

    @Column(name = "address", length = 90)
    private String address;

    @Column(name = "home_phone", length = 50)
    private String homePhone;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "education_place", length = 100)
    private String educationPlace;

    @Column(name = "graduation_year")
    private Integer graduationYear;

    @Column(name = "faculty", length = 70)
    private String faculty;

    @Column(name = "specialization", length = 50)
    private String specialization;

    @Column(name = "previous_workplace")
    private String previousWorkplace;

    @Column(name = "notes")
    private String notes;

    @Column(name = "working_conditions")
    private Double workingConditions;

    @Column(name = "labor_coefficient")
    private Double laborCoefficient;

    @Column(name = "user_login", length = 254)
    private String userLogin;

    @Column(name = "supervisor")
    private Integer supervisor;

    @Column(name = "passport_series", length = 2)
    private String passportSeries;

    @Column(name = "residential_address", length = 200)
    private String residentialAddress;

    @Column(name = "family_status")
    private String familyStatus;

    @Column(name = "passport_number", length = 7)
    private String passportNumber;

    @Column(name = "passport_date")
    private LocalDateTime passportDate;

    @Column(name = "passport_office", length = 200)
    private String passportOffice;

    @Column(name = "personal_number", length = 16)
    private String personalNumber;

    @Column(name = "mobile_phone_zone", length = 2)
    private String mobilePhoneZone;

    @Column(name = "mobile_phone", length = 9)
    private String mobilePhone;

    @Column(name = "profession1")
    private Integer profession1;

    @Column(name = "profession2")
    private Integer profession2;

    @Column(name = "profession3")
    private Integer profession3;

    @Column(name = "profession4")
    private Integer profession4;

    @Column(name = "profession5")
    private Integer profession5;

    @Column(name = "profession6")
    private Integer profession6;

    @Column(name = "height")
    private Integer height;

    @Column(name = "clothing_size")
    private Integer clothingSize;

    @Column(name = "shoe_size")
    private Integer shoeSize;

    @Column(name = "ppe_profession")
    private Integer ppeProfession;

    @Column(name = "size_code")
    private Integer sizeCode;

    @Column(name = "gender", length = 5)
    private String gender;

    @Override
    @JsonIgnore
    public Long getId() {
        return employeeId;
    }
}

