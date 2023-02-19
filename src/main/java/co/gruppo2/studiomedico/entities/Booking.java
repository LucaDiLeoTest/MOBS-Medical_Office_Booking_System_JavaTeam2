package co.gruppo2.studiomedico.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private long id;

    @Column(name = "booking_start_time")
    private LocalDateTime startingTime;

    @Column(name = "booking_end_time")
    private LocalDateTime endingTime;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Receptionist receptionist;

    @ManyToOne
    private Patient patient;

    /**
     * No args constructor.
     */
    public Booking() {
    }

    /**
     * All args constructor.
     * @param id
     * @param startingTime
     * @param endingTime
     * @param doctor
     * @param receptionist
     * @param patient
     */
    public Booking(long id, LocalDateTime startingTime, LocalDateTime endingTime, Doctor doctor, Receptionist receptionist, Patient patient) {
        this.id = id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.doctor = doctor;
        this.receptionist = receptionist;
        this.patient = patient;
    }

    // << SETTER AND GETTER >>
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
