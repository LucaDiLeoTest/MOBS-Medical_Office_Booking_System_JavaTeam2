package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_doctor")
    private Long id;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @ManyToOne(cascade = CascadeType.ALL)
    private Receptionist receptionist;

    @OneToMany(mappedBy = "doctor1", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    /**
     * No args constructor
     */
    public Doctor(){
    }

    /**
     * All args constructor
     * @param name
     * @param surname
     * @param email
     * @param telephoneNumber
     * @param personStatusEnum
     * @param patients
     * @param receptionist
     * @param bookings
     */
    public Doctor(String name, String surname, String email, String telephoneNumber, PersonStatusEnum personStatusEnum, List<Patient> patients, Receptionist receptionist, List<Booking> bookings) {
        super(name, surname, email, telephoneNumber, personStatusEnum);
        this.patients = patients;
        this.receptionist = receptionist;
        this.bookings = bookings;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//


    public Long getId() {
        return id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
