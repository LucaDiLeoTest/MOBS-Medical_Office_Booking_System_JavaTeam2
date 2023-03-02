package co.gruppo2.mobs.controllers;

import co.gruppo2.mobs.DTO.ReceptionistDTO;
import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    //---------------------------------------------CRUD SECRETARY-------------------------------------------------//
    @GetMapping("/")
    public String receptionistMsg(){
        return "You are in the receptionist controller!";
    }

    @GetMapping("/all")
    public List<Receptionist> getAllSecretaries(){
        return receptionistService.getAllReceptionist();
    }

    @GetMapping("/{id}")
    public Optional<Receptionist> findSecretaryById(@PathVariable Long id){
        return receptionistService.getReceptionistById(id);
    }

    @PostMapping("/")
    public ResponseEntity<ReceptionistDTO> createReceptionist(@RequestBody ReceptionistDTO receptionist){
        ReceptionistDTO receptionistDTO = receptionistService.createAndSaveReceptionist(receptionist);
        return new ResponseEntity<>(receptionistDTO, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
  public Receptionist updateSecretary(@PathVariable Long id, @RequestParam String email,
                                      @RequestParam String receptionistOfficeContact, String workPlace ){
        return receptionistService.saveOrUpdate(id,email,receptionistOfficeContact, workPlace);

    }
    @DeleteMapping("/{id}")
    public String deleteSecretary(@PathVariable Long id){
        receptionistService.deleteSecretaryById(id);
        return "The secretary has been eliminated";
    }

    @DeleteMapping("/delete_all")
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
    public Optional<Booking> findReservationById(@PathVariable Long id) {

        try {
            return receptionistService.getReservationById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @PutMapping("/update/{id}")
    public Booking updateReservation(@PathVariable Long id, LocalDateTime startingTime, LocalDateTime endingTime){
        return receptionistService.updateReservation(id, startingTime, endingTime);
    }

    @DeleteMapping("/delete_reservation/{id}")
    public String deleteReservation(@PathVariable Long id){
        try {
            receptionistService.deleteReservationById(id);
            return "The reservation has been deleted!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/delete_all_reservations")
    public String deleteAllReservations(){
        receptionistService.deleteAllReservations();
        return "All reservations has been deleted!";
    }

    //-------------LOGICAL MAPPING RESERVATION-------------//
    @PutMapping("/logical_change_status")
    public List<Booking> logicalChange(){
      return receptionistService.logicalSetStatus();
    }
    @DeleteMapping("/logical_deleted")
    public List<Booking> logicalDelete(){
        return receptionistService.logicalDelete();
    }



}
