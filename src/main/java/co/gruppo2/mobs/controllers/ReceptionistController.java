package co.gruppo2.mobs.controllers;

import co.gruppo2.mobs.DTO.ReceptionistDTO;
import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Receptionist create(@RequestBody ReceptionistDTO receptionistDTO) {

       Receptionist receptionist = receptionistService.createAndSaveReceptionist(receptionistDTO);
        return receptionist;

    }

    @GetMapping("")
    public List<Receptionist> getAll(){
        return receptionistService.getAllReceptionist();
    }

    @GetMapping("/{id}")
    public Optional<Receptionist> getOne(@PathVariable Long id){
        return receptionistService.getOne(id);
    }

    @PutMapping("/{id}")
    public Receptionist update(@PathVariable Long id, @RequestParam String email, String contact , String workplace){
        return receptionistService.saveOrUpdate(id, email, contact, workplace);
    }

    @DeleteMapping("/{id}")
    public Receptionist logicalDelete(@PathVariable Long id){
        return receptionistService.logicalDelete(id);
    }

}





