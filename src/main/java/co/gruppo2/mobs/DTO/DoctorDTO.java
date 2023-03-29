package co.gruppo2.mobs.DTO;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;

public class DoctorDTO {

    private Long id;

    private String name;

    private String surname;

    private String fiscalCode;

    private String email;

    private PersonStatusEnum personStatusEnum;



    public DoctorDTO(){};
    public DoctorDTO(Long id, String name, String surname, String fiscalCode, String email, PersonStatusEnum personStatusEnum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fiscalCode=fiscalCode;
        this.email = email;
        this.personStatusEnum = personStatusEnum;

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

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonStatusEnum getPersonStatusEnum() {
        return personStatusEnum;
    }

    public void setPersonStatusEnum(PersonStatusEnum personStatusEnum) {
        this.personStatusEnum = personStatusEnum;
    }
}
