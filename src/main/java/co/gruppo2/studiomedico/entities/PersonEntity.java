package co.gruppo2.studiomedico.entities;

import co.gruppo2.studiomedico.enumerations.PersonStatusEnum;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class PersonEntity {


    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(unique = true,nullable = false)
    private String email;
    @Enumerated
    private PersonStatusEnum personStatusEnum;


    public PersonEntity() {
    }

    public PersonEntity(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        personStatusEnum = PersonStatusEnum.ACTIVE;
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

    public PersonStatusEnum getPersonStatusEnum(){
        return personStatusEnum;
    }

    public void setPersonStatusEnum(PersonStatusEnum personStatusEnum){
        this.personStatusEnum = personStatusEnum;
    }
}

