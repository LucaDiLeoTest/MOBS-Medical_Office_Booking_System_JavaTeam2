package co.gruppo2.mobs.controllers;

import co.gruppo2.mobs.DTO.ReceptionistDTO;
import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    //---------------------------------------------CRUD SECRETARY-------------------------------------------------//
    @GetMapping("/welcomeMsg")
    public String receptionistMsg() {
        return "You are in the receptionist controller!";
    }


    /**l'api adesso ritorna correttamente il dto e non l'entity e in più se non viene inserite qualche campo del dto restituisce l'errore*/
    /**
     * FIXED
     */
    @PostMapping("/create_receptionist")
    public ResponseEntity<ReceptionistDTO> create(@RequestBody ReceptionistDTO receptionistDTO) {
        ReceptionistDTO receptionist = receptionistService.createReceptionist(receptionistDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(receptionist);
    }

    /**l'api adesso ritorna solo le segretarie con lo status attivo*/
    /**
     * FIXED
     */

    @GetMapping("/search_activeReceptionist")
    public List<ReceptionistDTO> getActiveSecretary() {
        return receptionistService.getAllReceptionistActive();
    }


    /**l'api ritorna la segretatia tramite l'id inserito se lo status della segretaria è attiva allora ci ritornerà correttamente*/
    /**
     * se invece lo status della segretaria è inattivo ci ritorna un'eccezione
     */
    @GetMapping("/search_receptionistById/{id}")
    public ResponseEntity<ReceptionistDTO> getOne(@PathVariable Long id) {
        ReceptionistDTO receptionist = receptionistService.getReceptionistByID(id);
        return ResponseEntity.ok(receptionist);
    }

    //Todo da controllare.
    @PutMapping("/{id}")
    public Receptionist update(@PathVariable Long id, @RequestParam String email, String contact, String workplace) {
        return receptionistService.saveOrUpdate(id, email, contact, workplace);
    }

    /**
     * Riattivazione di un entità cancellata logicamente, controllo se l'entità è già attiva scatterà l'exception
     */
    @PutMapping("/restore/{id}")
    public ResponseEntity<ReceptionistDTO> restoreReceptionist(@PathVariable Long id) throws Exception {
        ReceptionistDTO receptionistDTO = receptionistService.restoreReceptionist(id);
        return ResponseEntity.ok(receptionistDTO);
    }

    /**Cancellazione logica switcha lo stus dell'entità da active ad inactive preservando tutti gli altri dati */
    /**
     * ritorna correttamente il dto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ReceptionistDTO> logicalDelete(@PathVariable Long id) {
        ReceptionistDTO receptionistDTO = receptionistService.logicalDelete(id);
        return ResponseEntity.ok(receptionistDTO);
    }

}