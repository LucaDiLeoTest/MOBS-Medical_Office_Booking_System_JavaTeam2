package co.gruppo2.mobs.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDTO {

    private Long id;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private LocalDate date;
    private Long patientId;
    private String patientName;
    private String patientTelephoneNumber;
    private String patientEmail;
    private String doctorSurname;



    public BookingDTO(){
    }

    public BookingDTO(LocalTime startingTime, LocalTime endingTime, LocalDate date, Long patientId, String patientName, String patientTelephoneNumber, String patientEmail, String doctorSurname) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientTelephoneNumber = patientTelephoneNumber;
        this.patientEmail = patientEmail;
        this.doctorSurname = doctorSurname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientTelephoneNumber() {
        return patientTelephoneNumber;
    }

    public void setPatientTelephoneNumber(String patientTelephoneNumber) {
        this.patientTelephoneNumber = patientTelephoneNumber;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }
}

