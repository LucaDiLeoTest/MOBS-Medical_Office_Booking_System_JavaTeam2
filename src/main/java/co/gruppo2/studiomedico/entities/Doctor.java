package co.gruppo2.studiomedico.entities;

import co.gruppo2.studiomedico.enumerations.DoctorSpecialization;
import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor extends PersonEntity {

    @Column(name = "office_contact")
    private String officeContact;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "working_days")
    private String workingDays;


    public Doctor() {
    }

    public Doctor(Long id, String name, String surname, String email, String officeContact, String workplace, String workingDays) {
        super(id,name,surname,email);
        this.officeContact = officeContact;
        this.workplace = workplace;
        this.workingDays = workingDays;
    }


    //Getters and Setters
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
