package co.gruppo2.mobs.controllers;


import co.gruppo2.mobs.DTO.BookingResponseDTO;
import co.gruppo2.mobs.DTO.CreationBookingDTO;
import co.gruppo2.mobs.DTO.UpdateBookingDTO;
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

    @GetMapping("/bookingMsg")
    public String bookingMsg(){
        return "You are in the booking controller!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long id){
        return ResponseEntity.ok().body(bookingService.getBookingById(id));
    }

    /**
     * This endpoint return a list of all the confirmed bookings
     * @return
     */
    @GetMapping("/all")
    public List<BookingResponseDTO> getAllBooking(){
        return bookingService.getAllBookings();}

    @PostMapping("/")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody CreationBookingDTO creationBookingDTO){
        BookingResponseDTO bookingResponseDTO = bookingService.createBooking(creationBookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBooking(@PathVariable Long id, @RequestBody UpdateBookingDTO updateBookingDTO) {
        BookingResponseDTO bookingResponseDTO = bookingService.updateBooking(id, updateBookingDTO);
        return ResponseEntity.status(HttpStatus.OK).body(bookingResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> logicalDeleteBooking(@PathVariable long id){
        bookingService.logicalDeleteBooking(id);
        return ResponseEntity.status(HttpStatus.valueOf(204)).body("You delete the booking");
    }
}
