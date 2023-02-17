package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Receptionist;
import co.gruppo2.studiomedico.repositories.IReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService {

    @Autowired
    IReceptionistRepository receptionistRepository;

    public Receptionist createAndSaveReceptionist(Receptionist receptionist){
        return receptionistRepository.saveAndFlush(receptionist);
    }
}
