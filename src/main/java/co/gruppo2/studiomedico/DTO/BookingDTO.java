package co.gruppo2.studiomedico.DTO;

import co.gruppo2.studiomedico.enumerations.StatusReservation;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private LocalDateTime startingTime;
    private LocalDateTime endingTime;
    private StatusReservation statusReservation;
    private Long doctorId;
    private String doctorName;
    private String doctorSurname;
    private Long receptionistId;
    private String receptionistOfficeContact;
    private String receptionistWorkplace;
    private Long patientId;

    public BookingDTO(){
    }

    public BookingDTO(Long id,LocalDateTime startingTime,LocalDateTime endingTime,StatusReservation statusReservation
            ,Long doctorId,String doctorName,String doctorSurname,Long receptionistId,String receptionistOfficeContact
            ,String receptionistWorkplace,Long patientId){
        this.id = id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.statusReservation = statusReservation;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.receptionistId = receptionistId;
        this.receptionistOfficeContact = receptionistOfficeContact;
        this.receptionistWorkplace = receptionistWorkplace;
        this.patientId = patientId;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public LocalDateTime getStartingTime(){
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime){
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime(){
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime){
        this.endingTime = endingTime;
    }

    public StatusReservation getStatusReservation(){
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation){
        this.statusReservation = statusReservation;
    }

    public Long getDoctorId(){
        return doctorId;
    }

    public void setDoctorId(Long doctorId){
        this.doctorId = doctorId;
    }

    public String getDoctorName(){
        return doctorName;
    }

    public void setDoctorName(String doctorName){
        this.doctorName = doctorName;
    }

    public String getDoctorSurname(){
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname){
        this.doctorSurname = doctorSurname;
    }

    public Long getReceptionistId(){
        return receptionistId;
    }

    public void setReceptionistId(Long receptionistId){
        this.receptionistId = receptionistId;
    }

    public String getReceptionistOfficeContact(){
        return receptionistOfficeContact;
    }

    public void setReceptionistOfficeContact(String receptionistOfficeContact){
        this.receptionistOfficeContact = receptionistOfficeContact;
    }

    public String getReceptionistWorkplace(){
        return receptionistWorkplace;
    }

    public void setReceptionistWorkplace(String receptionistWorkplace){
        this.receptionistWorkplace = receptionistWorkplace;
    }

    public Long getPatientId(){
        return patientId;
    }

    public void setPatientId(Long patientId){
        this.patientId = patientId;
    }
}

