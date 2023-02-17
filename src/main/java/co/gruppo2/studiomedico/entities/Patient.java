package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private Long patientId;

    @Column(name = "name")
    private String patientName;
    @Column(name = "Surname")
    private String patientSurname;
    @Column(name = "email")
    private String patientEmail;
    @Column(name = "contact")
    private String patientContact;

    public Patient(){
    }

    public Patient(Long patientId,String patientName,String patientSurname,String patientEmail,String patientContact){
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientEmail = patientEmail;
        this.patientContact = patientContact;
    }

    public Long getPatientId(){
        return patientId;
    }

    public void setPatientId(Long patientId){
        this.patientId = patientId;
    }

    public String getPatientName(){
        return patientName;
    }

    public void setPatientName(String patientName){
        this.patientName = patientName;
    }

    public String getPatientSurname(){
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname){
        this.patientSurname = patientSurname;
    }

    public String getPatientEmail(){
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail){
        this.patientEmail = patientEmail;
    }

    public String getPatientContact(){
        return patientContact;
    }

    public void setPatientContact(String patientContact){
        this.patientContact = patientContact;
    }
}
