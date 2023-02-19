package co.gruppo2.studiomedico.controllers;


import co.gruppo2.studiomedico.entities.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @PostMapping("/")
    public void createBooking(@RequestBody Booking booking){
        System.out.println("");
    }

    @GetMapping("/bookinglist")
    public List<Booking> getBookingList(){
        return;}

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable long Id){
        return Booking ;
    }

    @PutMapping("/{id}")
    public void editBooking(@PathVariable long id, @RequestBody Booking booking){

    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable long id){

    }
}
