package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor extends PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_doctor")
    private Long id;

    @OneToOne(mappedBy = "doctor2", cascade = CascadeType.ALL)
    private ReceptionistEntity receptionist;


    @OneToMany(mappedBy = "doctor1", cascade = CascadeType.ALL)
    private List<Booking> bookings;


    public Doctor(){
    }

    public Doctor(Long id,String name,String surname,String email,String telephoneNumber){
        super(id,name,surname,email,telephoneNumber);
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
