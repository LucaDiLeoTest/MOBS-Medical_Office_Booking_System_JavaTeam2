package co.gruppo2.studiomedico.controllers;


import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.enumerations.BookingStatusEnum;
import co.gruppo2.studiomedico.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookinglist")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();}

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable long id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/")
    public Booking createBooking(@RequestBody Booking booking){
        booking.setBookingStatusEnum(BookingStatusEnum.PENDING);
        System.out.println("The booking has been successfully created and it's in pending!");
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void logicalDeleteBooking(@PathVariable long id){
        bookingService.logicalDeleteBooking(id);
    }
}
