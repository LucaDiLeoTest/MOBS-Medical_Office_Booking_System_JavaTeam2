package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "receptionists")
public class Receptionist extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receptionist")
    private Long id;

    /*@OneToMany(mappedBy = "receptionist", cascade = CascadeType.ALL)
    private List<Patient> patients;*/


    @OneToMany(mappedBy = "receptionist",cascade = CascadeType.ALL)
    private List<Doctor> doctorList;

    /*@OneToMany(mappedBy = "receptionist",cascade = CascadeType.ALL)
    private List<Booking> bookings;*/

    /**
     * No args constructor
     */
    public Receptionist(){
    }

    /**
     * All args constructor
     * @param name
     * @param surname
     * @param email
     * @param telephoneNumber
     * @param personStatusEnum
     * @param doctorList
     */
    public Receptionist(String name, String surname, String fiscalCode, String email, String telephoneNumber, PersonStatusEnum personStatusEnum, List<Doctor> doctorList) {
        super(name, surname,fiscalCode, email, telephoneNumber, personStatusEnum);
        this.doctorList = doctorList;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//


    public Long getId() {
        return id;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
