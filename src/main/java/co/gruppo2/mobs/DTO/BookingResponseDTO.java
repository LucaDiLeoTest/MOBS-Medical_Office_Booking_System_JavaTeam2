package co.gruppo2.mobs.DTO;

import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingResponseDTO {
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "HH:mm")
    private LocalTime startingTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "HH:mm")
    private LocalTime endingTime;

    private LocalDate date;

    private BookingStatusEnum bookingStatusEnum;

    private String doctorNameAndSurname;

    private String patientNameAndSurname;

    private String patientEmail;

    private String patientTelephoneNumber;

    private String patientFiscalCode;

    public BookingResponseDTO() {
    }

    public BookingResponseDTO(Long id, LocalTime startingTime, LocalTime endingTime, LocalDate date, BookingStatusEnum bookingStatusEnum, String doctorNameAndSurname, String patientNameAndSurname, String patientEmail, String patientTelephoneNumber, String patientFiscalCode) {
        this.id=id;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.bookingStatusEnum = bookingStatusEnum;
        this.doctorNameAndSurname = doctorNameAndSurname;
        this.patientNameAndSurname = patientNameAndSurname;
        this.patientEmail = patientEmail;
        this.patientTelephoneNumber = patientTelephoneNumber;
        this.patientFiscalCode = patientFiscalCode;
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

    public BookingStatusEnum getBookingStatusEnum() {
        return bookingStatusEnum;
    }

    public void setBookingStatusEnum(BookingStatusEnum bookingStatusEnum) {
        this.bookingStatusEnum = bookingStatusEnum;
    }

    public String getDoctorNameAndSurname() {
        return doctorNameAndSurname;
    }

    public void setDoctorNameAndSurname(String doctorNameAndSurname) {
        this.doctorNameAndSurname = doctorNameAndSurname;
    }

    public String getPatientNameAndSurname() {
        return patientNameAndSurname;
    }

    public void setPatientNameAndSurname(String patientNameAndSurname) {
        this.patientNameAndSurname = patientNameAndSurname;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientTelephoneNumber() {
        return patientTelephoneNumber;
    }

    public void setPatientTelephoneNumber(String patientTelephoneNumber) {
        this.patientTelephoneNumber = patientTelephoneNumber;
    }

    public String getPatientFiscalCode() {
        return patientFiscalCode;
    }

    public void setPatientFiscalCode(String patientFiscalCode) {
        this.patientFiscalCode = patientFiscalCode;
    }
}
