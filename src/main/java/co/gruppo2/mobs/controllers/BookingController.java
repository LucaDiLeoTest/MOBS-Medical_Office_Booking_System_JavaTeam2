package co.gruppo2.mobs.controllers;


import co.gruppo2.mobs.DTO.CreationBookingDTO;
import co.gruppo2.mobs.DTO.UpdateBookingDTO;
import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public String bookingMsg(){
        return "You are in the booking controller!";
    }

    /**
     * This endpoint return a list of all the confirmed bookings
     * @return
     */
    @GetMapping("/all")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();}

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createBooking(@RequestBody CreationBookingDTO creationBookingDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(creationBookingDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable Long id, @RequestBody UpdateBookingDTO updateBookingDTO) {
        String body= bookingService.updateBooking(id, updateBookingDTO);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public Booking logicalDeleteBooking(@PathVariable long id){
        return bookingService.logicalDeleteBooking(id);
    }
}
