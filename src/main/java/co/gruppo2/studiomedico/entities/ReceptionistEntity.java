package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
public class ReceptionistEntity extends PersonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receptionist")
    private Long id;
    @Column(name = "receptionist_office_contact")
    private String receptionistOfficeContact;
    @Column(name = "receptionist_workplace")
    private String receptionistWorkPlace;

    public ReceptionistEntity() {
    }

    public ReceptionistEntity(String name,String surname,String email,String receptionistOfficeContact,
                              String receptionistWorkplace){
        super(name,surname,email);
        this.receptionistOfficeContact = receptionistOfficeContact;
        this.receptionistWorkPlace = receptionistWorkplace;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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
