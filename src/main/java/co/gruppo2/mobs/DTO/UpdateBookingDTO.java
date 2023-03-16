package co.gruppo2.mobs.DTO;

import co.gruppo2.mobs.enumerations.BookingStatusEnum;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateBookingDTO {

    private LocalTime startingTime;
    private LocalTime endingTime;
    private LocalDate date;
    private BookingStatusEnum bookingStatusEnum;


    /**
     * No args constructor
     */
    public UpdateBookingDTO() {
    }

    /**
     * All args constructor
     * @param startingTime
     * @param endingTime
     * @param date
     * @param bookingStatusEnum
     */
    public UpdateBookingDTO(LocalTime startingTime, LocalTime endingTime, LocalDate date, BookingStatusEnum bookingStatusEnum) {
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.bookingStatusEnum = bookingStatusEnum;
    }

    //---------------------------------------------GETTER AND SETTER-------------------------------------------------//
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
}
