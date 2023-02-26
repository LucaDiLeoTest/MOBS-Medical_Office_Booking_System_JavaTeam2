package co.gruppo2.studiomedico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;

@Entity
@Table(name = "patients")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient extends PersonEntity{

    @Column(unique = true, nullable = false)
    private String telephoneNumber;


    public Patient(){
    }

    public Patient(Long id,String name,String surname,String email,String telephoneNumber){
        super(id,name,surname,email);
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber(){
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }
}
