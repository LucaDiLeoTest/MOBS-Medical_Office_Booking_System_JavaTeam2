package co.gruppo2.studiomedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "patients")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient extends PersonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_patient")
    private Long id;
    @Column(unique = true, nullable = false)
    private String telephoneNumber;


    public Patient(){
    }

    public Patient(String name,String surname,String email,Long id,String telephoneNumber){
        super(name,surname,email);
        this.id = id;
        this.telephoneNumber = telephoneNumber;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTelephoneNumber(){
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }
}
