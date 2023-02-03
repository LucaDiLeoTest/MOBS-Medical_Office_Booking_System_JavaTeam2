package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    @Column(name = "name")
    private String doctorName;
    @Column(name = "surname")
    private String doctorSurname;
    @Column(name = "specialization")
    private DoctorSpecialization specialization;
    @Column(name = "email")
    private String doctorEmail;
    @Column(name = "office_contact")
    private String officeContact;
    @Column(name = "workplace")
    private String workplace;
    @Column(name = "working_days")
    private String workingDays;


    public Doctor() {
    }

    public Doctor(int doctorId, String doctorName, String doctorSurname, DoctorSpecialization specialization, String doctorEmail, String officeContact, String workplace, String workingDays) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.specialization = specialization;
        this.doctorEmail = doctorEmail;
        this.officeContact = officeContact;
        this.workplace = workplace;
        this.workingDays = workingDays;
    }


    //Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public DoctorSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(DoctorSpecialization specialization) {
        this.specialization = specialization;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
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
