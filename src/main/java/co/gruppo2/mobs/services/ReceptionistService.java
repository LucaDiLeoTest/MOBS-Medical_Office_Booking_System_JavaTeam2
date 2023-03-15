package co.gruppo2.mobs.services;

import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService{

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    IBookingRepository bookingRepository;


//------------------------------------------Receptionist Logic-------------------------------------------//

    /**
     * Creates and saves a new receptionist entity with the given receptionistDTO
     *
     * @param receptionist The DTO containing the receptionist's data
     * @return The saved receptionist DTO
     */
    public Receptionist createAndSaveReceptionist(Receptionist receptionist){
        receptionist.setPersonStatusEnum(PersonStatusEnum.ACTIVE);
       return receptionistRepository.save(receptionist);
    }

    /**
     *
     * Retrieves receptionist found by id
     * @return receptionist found
     */


    public Optional<Receptionist> getOne(Long id){
      return receptionistRepository.findById(id);
    }

    /**
     * Retrieves all receptionist entities
     *
     * @return A list containing all receptionist entities
     */
    public List<Receptionist> getAllReceptionist(){
        return receptionistRepository.findAll();
    }


    /**
     * Saves or updates a receptionist entity with the given data
     *
     * @param id        The id of the receptionist to save or update
     * @param email     The new email to set for the receptionist
     * @param contact   The new contact information to set for the receptionist
     * @param workPlace The new work place to set for the receptionist
     * @return The saved or updated receptionist entity
     */
    public Receptionist saveOrUpdate(Long id, String email, String contact, String workPlace){
        Receptionist receptionist;
        if(receptionistRepository.existsById(id)){
            receptionist = receptionistRepository.getById(id);
            receptionist.setEmail(email);
            receptionist.setTelephoneNumber(contact);
            return receptionistRepository.save(receptionist);
        } else {
            receptionist = new Receptionist();
        }
        return receptionist;
    }


    /**
     * Deletes a receptionist entity by its id
     *
     * @param id The id of the receptionist to delete
     */
    public Receptionist logicalDelete(Long id) {
        Receptionist receptionist;
        if (receptionistRepository.existsById(id)) {
            receptionist = receptionistRepository.getById(id);
            receptionist.setPersonStatusEnum(PersonStatusEnum.INACTIVE);
            return receptionistRepository.save(receptionist);
        } else {
            receptionist = new Receptionist();
        }

        return receptionist;
    }

}












