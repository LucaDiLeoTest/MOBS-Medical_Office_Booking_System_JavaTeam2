package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "receptionist")
public class ReceptionistEntity extends PersonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_receptionist")
    private Long id;
    /*@OneToMany(mappedBy = "receptionist", cascade = CascadeType.ALL)
    private List<Patient> patients;*/

    @OneToOne( cascade = CascadeType.ALL)
    private Doctor doctor2;

    /*@OneToMany(mappedBy = "receptionist",cascade = CascadeType.ALL)
    private List<Booking> bookings;*/

    public ReceptionistEntity(){
    }

    public ReceptionistEntity(Long id,String name,String surname,String email,String telephoneNumber){
        super(id,name,surname,email,telephoneNumber);
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


}
