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

    /*@OneToOne(mappedBy = "doctor2", cascade = CascadeType.ALL)
    private ReceptionistEntity receptionist;*/

    @OneToMany(mappedBy = "doctor1", cascade = CascadeType.ALL)
    private List<Booking> bookings;


    public Doctor(){
    }

    public Doctor(Long id, String name, String surname, String email, String telephoneNumber, PersonStatusEnum personStatusEnum){
        super(id,name,surname,email,telephoneNumber, personStatusEnum);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public List<Booking> getBookings(){
        return bookings;
    }

    public void setBookings(List<Booking> bookings){
        this.bookings = bookings;
    }
}
