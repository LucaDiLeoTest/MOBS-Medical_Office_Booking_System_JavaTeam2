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

    //---------------------------------------------CRUD SECRETARY-------------------------------------------------//
    @PostMapping("/add_secretary")
    public Receptionist createReceptionist(@RequestBody Receptionist receptionist){
        receptionistService.createAndSaveReceptionist(receptionist);
        return receptionist;
    }

    @GetMapping("/all_secretaries")
    public List<Receptionist> getAllSecretaries(){
        return receptionistService.getAllReceptionist();
    }

    @GetMapping("/find_secretary/{id}")
    public Optional<Receptionist> findSecretaryById(@PathVariable Long id){
        return receptionistService.getReceptionistById(id);
    }

    @PutMapping("/update_secretary")
    public Receptionist updateSecretary(@RequestParam Long id, @RequestParam String name,  @RequestParam String surname,
                                        @RequestParam String email,  @RequestParam String officeContact,
                                        @RequestParam String workPlace){
        return receptionistService.updateReceptionist(id, name, surname, email, officeContact, workPlace);
    }

    @DeleteMapping("/delete_secretary/{id}")
    public String deleteSecretary(@PathVariable Long id){
        receptionistService.deleteSecretaryById(id);
        return "The secretary has been eliminated";
    }

    @DeleteMapping("/delete_all_secretaries")
    public String deleteAllSecretaries(){
        receptionistService.deleteAllSecretary();
        return "all secretaries have been eliminated";
    }


    //----------------------------------------CRUD RESERVATION--------------------------------------------//

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
