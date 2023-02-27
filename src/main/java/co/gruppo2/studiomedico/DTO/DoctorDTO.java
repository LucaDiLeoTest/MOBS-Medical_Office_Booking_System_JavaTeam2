package co.gruppo2.studiomedico.DTO;

import jakarta.validation.constraints.Pattern;

public class DoctorDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    @Pattern(regexp = "\\d{10}", message = "The number contains max 10 numbers")
    private String officeContact;

    private String workplace;

    private String workingDays;

    public DoctorDTO(Long id, String name, String surname, String email, String officeContact, String workplace, String workingDays) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.officeContact = officeContact;
        this.workplace = workplace;
        this.workingDays = workingDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeContact() {
        return officeContact;
    }

    public void setOfficeContact(String officeContact) {
        this.officeContact = officeContact;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }
}
