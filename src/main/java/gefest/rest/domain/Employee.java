package gefest.rest.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    /*
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "employee_id_seq", allocationSize=1)
     */
    private Long employeeId;

    @Column(nullable = false)
    private int nTabelnyj;

    @Column(nullable = false)
    private Long deptId;

    @Column(length = 20)
    private String zveno;

    @Column(nullable = false, length = 64)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String secondName;

    @Column(nullable = false, length = 64)
    private String fullName;

    private Long position;
    private int rank;

    private Date dateOfEmployment;

    private boolean working = true;

    private long categoryId;

    @Column(length = 128)
    private String  address;

    @Column(length = 64)
    private String homePhone;

    private Date birthday;

    @Column(length = 256)
    private String birthplace;

    @Column(length = 128)
    private String education;
    private int eduYear;

    @Column(length = 128)
    private String faculty;

    @Column(length = 64)
    private String  specialty;

    @Column(length = 256)
    private String previousEmployment;

    @Column(length = 256)
    private String note;

    private double workingConditions;

    private double salary;

    @Column(length = 256)
    private String userLogin;

    private Long managerId;

    @Column(length = 8)
    private String passportSeries;

    @Column(length = 16)
    private String passportNumber;

    private Date passportDate;

    @Column(length = 256)
    private String passportOffice;

    @Column(length = 16)
    private String personalNumber;

    @Column(length = 256)
    private String realAddress;

    @Column(length = 256)
    private String familyStatus;

    @Column(length = 4)
    private String mobilePhoneZone;

    @Column(length = 16)
    private  String mobilePhone;

    private long professionId1;
    private long professionId2;
    private long professionId3;
    private long professionId4;
    private long professionId5;
    private long professionId6;
    private int height;
    private int clothingSize;
    private int shoeSize;
    private long meansOfProtectionByPosition;
    private long clothingSizeTypeId;

    @Column(length = 8)
    private String gender;

    public Employee() {    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getnTabelnyj() {
        return nTabelnyj;
    }

    public void setnTabelnyj(int nTabelnyj) {
        this.nTabelnyj = nTabelnyj;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getZveno() {
        return zveno;
    }

    public void setZveno(String zveno) {
        this.zveno = zveno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getEduYear() {
        return eduYear;
    }

    public void setEduYear(int eduYear) {
        this.eduYear = eduYear;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPreviousEmployment() {
        return previousEmployment;
    }

    public void setPreviousEmployment(String previousEmployment) {
        this.previousEmployment = previousEmployment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getWorkingConditions() {
        return workingConditions;
    }

    public void setWorkingConditions(double workingConditions) {
        this.workingConditions = workingConditions;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(Date passportDate) {
        this.passportDate = passportDate;
    }

    public String getPassportOffice() {
        return passportOffice;
    }

    public void setPassportOffice(String passportOffice) {
        this.passportOffice = passportOffice;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getMobilePhoneZone() {
        return mobilePhoneZone;
    }

    public void setMobilePhoneZone(String mobilePhoneZone) {
        this.mobilePhoneZone = mobilePhoneZone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public long getProfessionId1() {
        return professionId1;
    }

    public void setProfessionId1(long professionId1) {
        this.professionId1 = professionId1;
    }

    public long getProfessionId2() {
        return professionId2;
    }

    public void setProfessionId2(long professionId2) {
        this.professionId2 = professionId2;
    }

    public long getProfessionId3() {
        return professionId3;
    }

    public void setProfessionId3(long professionId3) {
        this.professionId3 = professionId3;
    }

    public long getProfessionId4() {
        return professionId4;
    }

    public void setProfessionId4(long professionId4) {
        this.professionId4 = professionId4;
    }

    public long getProfessionId5() {
        return professionId5;
    }

    public void setProfessionId5(long professionId5) {
        this.professionId5 = professionId5;
    }

    public long getProfessionId6() {
        return professionId6;
    }

    public void setProfessionId6(long professionId6) {
        this.professionId6 = professionId6;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getClothingSize() {
        return clothingSize;
    }

    public void setClothingSize(int clothingSize) {
        this.clothingSize = clothingSize;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public long getMeansOfProtectionByPosition() {
        return meansOfProtectionByPosition;
    }

    public void setMeansOfProtectionByPosition(long meansOfProtectionByPosition) {
        this.meansOfProtectionByPosition = meansOfProtectionByPosition;
    }

    public long getClothingSizeTypeId() {
        return clothingSizeTypeId;
    }

    public void setClothingSizeTypeId(long clothingSizeTypeId) {
        this.clothingSizeTypeId = clothingSizeTypeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
