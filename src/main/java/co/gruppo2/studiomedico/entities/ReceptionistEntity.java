package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
public class ReceptionistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receptionistId;

    @Column(name = "receptionist_name")
    private String receptionistName;
    @Column(name = "receptionist_surname")
    private String receptionistSurname;
    @Column(name = "receptionist_email")
    private String receptionistEmail;
    @Column(name = "receptionist_office_contact")
    private String receptionistOfficeContact;
    @Column(name = "receptionist_workplace")
    private String receptionistWorkplace;

    public ReceptionistEntity() {
    }

    public ReceptionistEntity(Long receptionistId, String receptionistName, String receptionistSurname, String receptionistEmail, String receptionistOfficeContact, String receptionistWorkplace) {
        this.receptionistId = receptionistId;
        this.receptionistName = receptionistName;
        this.receptionistSurname = receptionistSurname;
        this.receptionistEmail = receptionistEmail;
        this.receptionistOfficeContact = receptionistOfficeContact;
        this.receptionistWorkplace = receptionistWorkplace;
    }

    //Getters and Setters


    public Long getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(Long receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    public String getReceptionistSurname() {
        return receptionistSurname;
    }

    public void setReceptionistSurname(String receptionistSurname) {
        this.receptionistSurname = receptionistSurname;
    }

    public String getReceptionistEmail() {
        return receptionistEmail;
    }

    public void setReceptionistEmail(String receptionistEmail) {
        this.receptionistEmail = receptionistEmail;
    }

    public String getReceptionistOfficeContact() {
        return receptionistOfficeContact;
    }

    public void setReceptionistOfficeContact(String receptionistOfficeContact) {
        this.receptionistOfficeContact = receptionistOfficeContact;
    }

    public String getReceptionistWorkplace() {
        return receptionistWorkplace;
    }

    public void setReceptionistWorkplace(String receptionistWorkplace) {
        this.receptionistWorkplace = receptionistWorkplace;
    }
}
