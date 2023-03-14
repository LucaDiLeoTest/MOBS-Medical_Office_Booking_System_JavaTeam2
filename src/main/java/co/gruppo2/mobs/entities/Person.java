package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephoneNumber;
    @Enumerated(EnumType.STRING)
    private PersonStatusEnum personStatusEnum;


    public Person() {
    }

    public Person(Long id, String name, String surname, String email, String telephoneNumber, PersonStatusEnum personStatusEnum){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.personStatusEnum = personStatusEnum;
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

    public String getTelephoneNumber(){
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }

    public PersonStatusEnum getPersonStatusEnum(){
        return personStatusEnum;
    }

    public void setPersonStatusEnum(PersonStatusEnum personStatusEnum){
        this.personStatusEnum = personStatusEnum;
    }
}

