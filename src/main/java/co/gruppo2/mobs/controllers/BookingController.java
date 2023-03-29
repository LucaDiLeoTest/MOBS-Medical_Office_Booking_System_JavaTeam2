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

    @GetMapping("/all_confirmed_bookings")
    public ResponseEntity<List<BookingResponseDTO>> getAllBooking(){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllBookings());
    }

    @GetMapping("/all_pending_bookings")
    public ResponseEntity<List<BookingResponseDTO>> getAllPendingBookings(){
     return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllPendingBookings());
    }

    @GetMapping("/all_deleted_bookings")
    public ResponseEntity<List<BookingResponseDTO>> getAllDeletedOrExpiredBookings(){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllDeletedOrExpiredBookings());
    }

    @GetMapping("/all_daily_bookings")
    public ResponseEntity<List<BookingResponseDTO>> getAllDailyBookings(){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllDailyBooking());
    }


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
