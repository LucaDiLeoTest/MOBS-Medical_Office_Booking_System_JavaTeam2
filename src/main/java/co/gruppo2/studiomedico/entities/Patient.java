package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;

    @Column(name = "name")
    private String patientName;
    @Column(name = "Surname")
    private String patientSurname;
    @Column(name = "email")
    private String patientEmail;
    @Column(name = "contact")
    private String patientContact;
}
