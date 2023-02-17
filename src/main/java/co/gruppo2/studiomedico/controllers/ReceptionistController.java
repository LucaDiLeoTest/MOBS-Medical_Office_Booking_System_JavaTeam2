package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.entities.Receptionist;
import co.gruppo2.studiomedico.services.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;
    @PostMapping("/add")
    public Receptionist createReceptionist(@RequestBody Receptionist receptionist){
        receptionistService.createAndSaveReceptionist(receptionist);
        return receptionist;
    }
}
