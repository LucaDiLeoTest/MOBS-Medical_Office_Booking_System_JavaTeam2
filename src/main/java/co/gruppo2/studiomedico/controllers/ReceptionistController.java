package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.entities.ReceptionistEntity;
import co.gruppo2.studiomedico.enumerations.StatusReservation;
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
    public ReceptionistEntity createReceptionist(@RequestBody ReceptionistEntity receptionist){
        receptionistService.createAndSaveReceptionist(receptionist);
        return receptionist;
    }

    @GetMapping("/all_secretaries")
    public List<ReceptionistEntity> getAllSecretaries(){
        return receptionistService.getAllReceptionist();
    }

    @GetMapping("/find_secretary/{id}")
    public Optional<ReceptionistEntity> findSecretaryById(@PathVariable Long id){
        return receptionistService.getReceptionistById(id);
    }

    @PutMapping("/update_secretary/{id}")
  public ReceptionistEntity updateSecretary(@PathVariable Long id,  @RequestParam String email,
                                            @RequestParam String receptionistOfficeContact, String workPlace ){
        return receptionistService.saveOrUpdate(id,email,receptionistOfficeContact, workPlace);

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

    @PutMapping("/update/{id}")
    public Booking updateReservation(@PathVariable Long id, LocalDateTime startingTime, LocalDateTime endingTime){
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

    //-----------------WORK IN PROGRESS--------------------------//

    /**
     * LOGICAL DELETE WORK IN PROGRESS...
     */

    @DeleteMapping("/logical_deleted")
    public List<Booking> logicalDelete(){
     return receptionistService.logicalDelete();
    }

    @PutMapping("/logical_change_status")
    public List<Booking> logicalChange(){
      return receptionistService.logicalSetStatus();
    }
}
