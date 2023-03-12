package co.gruppo2.mobs.DTO;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private LocalDateTime startingTime;
    private Long doctorId;
    private String doctorName;
    private String doctorSurname;
    private Long patientId;

    public BookingDTO(){
    }

    public BookingDTO(LocalDateTime startingTime, Long doctorId, String doctorName, String doctorSurname, Long patientId) {
        this.startingTime = startingTime;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.patientId = patientId;
    }


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
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}

