package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "fiscal_code", nullable = false, unique = true)
    private String fiscalCode;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "telephone_number",unique = true)
    private String telephoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_status")
    private PersonStatusEnum personStatusEnum;

    /**
     * No args constructor
     */
    public Person() {
    }

    /**
     * All args constructor
     * @param name
     * @param surname
     * @param fiscalCode
     * @param email
     * @param telephoneNumber
     * @param personStatusEnum
     */
    public Person(String name, String surname, String fiscalCode, String email, String telephoneNumber, PersonStatusEnum personStatusEnum) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.personStatusEnum = personStatusEnum;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public PersonStatusEnum getPersonStatusEnum() {
        return personStatusEnum;
    }

    public void setPersonStatusEnum(PersonStatusEnum personStatusEnum) {
        this.personStatusEnum = personStatusEnum;
    }
}
