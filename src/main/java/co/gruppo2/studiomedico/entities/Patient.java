package co.gruppo2.studiomedico.entities;

import co.gruppo2.studiomedico.enumerations.PersonStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
public class Patient extends PersonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private ReceptionistEntity receptionist;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Patient(){
    }

    public Patient(Long id,String name,String surname,String email,String telephoneNumber){
        super(id,name,surname,email,telephoneNumber);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public ReceptionistEntity getReceptionist(){
        return receptionist;
    }

    public void setReceptionist(ReceptionistEntity receptionist){
        this.receptionist = receptionist;
    }

    public List<Booking> getBookings(){
        return bookings;
    }

    public void setBookings(List<Booking> bookings){
        this.bookings = bookings;
    }
}
