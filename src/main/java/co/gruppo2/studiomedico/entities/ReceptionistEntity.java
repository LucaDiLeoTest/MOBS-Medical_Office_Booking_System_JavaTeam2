package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
public class ReceptionistEntity extends PersonEntity{

    @Column(name = "receptionist_office_contact")
    private String receptionistOfficeContact;
    @Column(name = "receptionist_workplace")
    private String receptionistWorkPlace;

    public ReceptionistEntity() {
    }

    public ReceptionistEntity(Long id, String name, String surname, String email, String receptionistOfficeContact, String receptionistWorkplace) {
        super(id, name, surname, email);
        this.receptionistOfficeContact = receptionistOfficeContact;
        this.receptionistWorkPlace = receptionistWorkplace;
    }

    //Getters and Setters

    public String getReceptionistOfficeContact() {
        return receptionistOfficeContact;
    }

    public void setReceptionistOfficeContact(String receptionistOfficeContact) {
        this.receptionistOfficeContact = receptionistOfficeContact;
    }

    public String getReceptionistWorkPlace() {
        return receptionistWorkPlace;
    }

    public void setReceptionistWorkPlace(String receptionistWorkPlace) {
        this.receptionistWorkPlace = receptionistWorkPlace;
    }
}
