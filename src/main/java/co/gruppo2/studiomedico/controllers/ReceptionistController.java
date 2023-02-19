package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.entities.Receptionist;
import co.gruppo2.studiomedico.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;
    @PostMapping("/add_secretary")
    public Receptionist createReceptionist(@RequestBody Receptionist receptionist){
        receptionistService.createAndSaveReceptionist(receptionist);
        return receptionist;
    }

    //CRUD RESERVATION//

    @PostMapping("/add_reservation")
    public Booking saveReservation(@RequestBody Booking booking) {
        receptionistService.createAndSaveReservation(booking);
        return booking;
    }

    @GetMapping("/all_reservations")
    public List<Booking> getReservations(){
        return receptionistService.getAllReservations();
    }

    @GetMapping("/find_reservation/{id}")
    public Optional<Booking> findReservationById(@PathVariable Long id){
        return receptionistService.getReservationById(id);
    }

    @PutMapping("/update")
    public Booking updateReservation(@RequestParam Long id, LocalDateTime startingTime, LocalDateTime endingTime){
        return receptionistService.updateReservation(id, startingTime, endingTime);
    }

    @DeleteMapping("/delete_reservation/{id}")
    public String deleteReservation(@PathVariable Long id){
        receptionistService.deleteReservationById(id);
        return "The reservation has been deleted!";
    }

    @DeleteMapping("/delete_all_reservations")
    public String deleteAllReservations(){
        receptionistService.deleteAllReservations();
        return "All reservations has been deleted!";
    }
}
