package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
public class ReceptionistEntity extends PersonEntity{

    @Column(name = "receptionist_office_contact")
    private String receptionistOfficeContact;
    @Column(name = "receptionist_workplace")
    private String receptionistWorkplace;

    public ReceptionistEntity() {
    }

    public ReceptionistEntity(Long id, String name, String surname, String email, String receptionistOfficeContact, String receptionistWorkplace) {
        super(id, name, surname, email);
        this.receptionistOfficeContact = receptionistOfficeContact;
        this.receptionistWorkplace = receptionistWorkplace;
    }

    //Getters and Setters

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
