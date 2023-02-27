package co.gruppo2.studiomedico.DTO;

public class ReceptionistDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String officeContactReceptionist;

    private String receptionistWorkPlace;

    public ReceptionistDTO() {
    }

    public ReceptionistDTO(Long id, String name, String surname, String email, String officeContactReceptionist, String workPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.officeContactReceptionist = officeContactReceptionist;
        this.receptionistWorkPlace = workPlace;
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

    public String getOfficeContactReceptionist() {
        return officeContactReceptionist;
    }

    public void setOfficeContactReceptionist(String officeContactReceptionist) {
        this.officeContactReceptionist = officeContactReceptionist;
    }

    public String getReceptionistWorkPlace() {
        return receptionistWorkPlace;
    }

    public void setReceptionistWorkPlace(String receptionistWorkPlace) {
        this.receptionistWorkPlace = receptionistWorkPlace;
    }
}
