package co.gruppo2.studiomedico.controllers;


import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public Booking createBooking(@RequestBody Booking booking){
        System.out.println("The booking has been created!");
        return bookingService.createBooking(booking);
    }

    @GetMapping("/bookinglist")
    public List<Booking> getBookingList(){
        return bookingService.getAllBooking();}

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable long id){
        return bookingService.findBookingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable long id){
        System.out.println("The booking "+id+" has been deleted!");
    }
}
