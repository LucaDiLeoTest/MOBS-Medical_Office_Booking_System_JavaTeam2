package co.gruppo2.studiomedico.entities;

import co.gruppo2.studiomedico.enumerations.BookingStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private Long id;

    @Column(name = "booking_start_time")
    private LocalDateTime startingTime;

    @Column(name = "booking_end_time")
    private LocalDateTime endingTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatusEnum bookingStatusEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    /**
     * No args constructor
     */
    public Booking() {
    }

    /**
     * All args constructor
     * @param startingTime
     * @param endingTime
     * @param bookingStatusEnum
     * @param doctor
     * @param patient
     */
    public Booking(LocalDateTime startingTime,LocalDateTime endingTime,BookingStatusEnum bookingStatusEnum,
                   Doctor doctor,Patient patient){
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.bookingStatusEnum = bookingStatusEnum;
        this.doctor = doctor;
        this.patient = patient;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
        this.endingTime = startingTime.plusMinutes(30);                 //set the endingTime with a delay of 30 min
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public BookingStatusEnum getBookingStatusEnum() {
        return bookingStatusEnum;
    }

    public void setBookingStatusEnum(BookingStatusEnum bookingStatusEnum) {
        this.bookingStatusEnum = bookingStatusEnum;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}