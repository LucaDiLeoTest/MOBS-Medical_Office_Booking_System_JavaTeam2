package co.gruppo2.mobs.entities;

import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "booking")
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private Long id;

    @Column(name = "booking_start_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startingTime;

    @Column(name = "booking_end_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endingTime;

    @Column(name="date_booking")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatusEnum bookingStatusEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_doctor")
    private Doctor doctor;

    /*@ManyToOne(fetch = FetchType.LAZY)
    private ReceptionistEntity receptionist;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_patient")
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
     * @param date
     * @param bookingStatusEnum
     * @param doctor
     * @param patient
     */
    public Booking(LocalTime startingTime, LocalTime endingTime, LocalDate date, BookingStatusEnum bookingStatusEnum, Doctor doctor, Patient patient) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.bookingStatusEnum = bookingStatusEnum;
        this.doctor = doctor;
        this.patient = patient;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//
    public Long getId() {
        return id;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
        this.endingTime = startingTime.plusMinutes(30);          //set the endingTime with a delay of 30 min
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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