package co.gruppo2.mobs.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreationBookingDTO {

    private LocalTime startingTime;
    private LocalDate date;
    private Long patientId;
    private Long doctorId;

    /**
     * No args constructor
     */
    public CreationBookingDTO() {
    }

    /**
     * All args constructor
     * @param startingTime
     * @param date
     * @param patientId
     * @param doctorId
     */
    public CreationBookingDTO(LocalTime startingTime, LocalDate date, Long patientId, Long doctorId) {
        this.startingTime = startingTime;
        this.date = date;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//
    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
