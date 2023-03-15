package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
public class Patient extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private Long id;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Column(name = "gender",nullable = false)
    private Long gender;

    @Column(name = "fiscal_code",nullable = false,unique = true)
    private String fiscalCode;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    /*@ManyToOne(fetch = FetchType.LAZY)
    private ReceptionistEntity receptionist;*/

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    /**
     * No args constructor
     */
    public Patient(){
    }

    /**
     * All args constructor
     * @param name
     * @param surname
     * @param email
     * @param telephoneNumber
     * @param personStatusEnum
     * @param age
     * @param gender
     * @param fiscalCode
     * @param address
     * @param doctor
     * @param bookings
     */
    public Patient(String name, String surname, String email, String telephoneNumber, PersonStatusEnum personStatusEnum, Integer age, Long gender, String fiscalCode, String address, Doctor doctor, List<Booking> bookings) {
        super(name, surname, email, telephoneNumber, personStatusEnum);
        this.age = age;
        this.gender = gender;
        this.fiscalCode = fiscalCode;
        this.address = address;
        this.doctor = doctor;
        this.bookings = bookings;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//


    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
