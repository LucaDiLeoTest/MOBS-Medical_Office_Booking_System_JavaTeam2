package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.ReceptionistDTO;
import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IReceptionistRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceptionistService{

    @Autowired
    IReceptionistRepository receptionistRepository;




//------------------------------------------Receptionist Logic-------------------------------------------//

    /**
     * Creates and saves a new receptionist entity with the given receptionistDTO
     *
     * @param receptionistDTO The DTO containing the receptionist's data
     * @return The saved receptionist DTO
     */
    public ReceptionistDTO createReceptionist(ReceptionistDTO receptionistDTO){
        Receptionist receptionist = new Receptionist();
        receptionist.setName(receptionistDTO.getName());
        receptionist.setSurname(receptionistDTO.getSurname());
        receptionist.setFiscalCode(receptionistDTO.getFiscalCode());
        receptionist.setEmail(receptionistDTO.getEmail());
        receptionist.setTelephoneNumber(receptionistDTO.getTelephoneNumber());
        receptionist.setPersonStatusEnum(PersonStatusEnum.ACTIVE);

        receptionistRepository.save(receptionist);

        return new ReceptionistDTO(receptionist.getId(), receptionist.getName(),receptionist.getSurname(), receptionist.getFiscalCode(),
                                    receptionist.getEmail(), receptionist.getTelephoneNumber(), receptionist.getPersonStatusEnum());
    }

    /**
     *
     * Retrieves receptionist found by id
     * @return receptionist found
     */


    public ReceptionistDTO getReceptionistByID(Long id) {
        Optional<Receptionist> receptionist = receptionistRepository.findById(id);
        if (receptionist.isPresent()) {

            Receptionist r = receptionist.get();

            if (r.getPersonStatusEnum() == PersonStatusEnum.INACTIVE){
                throw new EntityNotFoundException("Receptionist with id " + id + " is inactive");
            }

            return new ReceptionistDTO(
                    receptionist.get().getId(),
                    receptionist.get().getName(),
                    receptionist.get().getSurname(),
                    receptionist.get().getFiscalCode(),
                    receptionist.get().getEmail(),
                    receptionist.get().getTelephoneNumber(),
                    receptionist.get().getPersonStatusEnum()
            );

        } else {
            throw new EntityNotFoundException("Receptionist not found with id " + id);
        }

    }


    /**
     * Retrieves all receptionist entities
     *
     * @return A list containing all receptionist entities
     */
    public List<ReceptionistDTO> getAllReceptionistActive(){

        List<Receptionist> receptionists = receptionistRepository.findByPersonStatusEnum(PersonStatusEnum.ACTIVE);
        List<ReceptionistDTO> receptionistDTOs = receptionists.stream()
                .map(receptionist -> new ReceptionistDTO(
                        receptionist.getId(),
                        receptionist.getName(),
                        receptionist.getSurname(),
                        receptionist.getFiscalCode(),
                        receptionist.getEmail(),
                        receptionist.getTelephoneNumber(),
                        receptionist.getPersonStatusEnum()))
                .collect(Collectors.toList());
        return receptionistDTOs;
    }

    public List<ReceptionistDTO> getAllReceptionistDeleted(){

        List<Receptionist> receptionists = receptionistRepository.findByPersonStatusEnum(PersonStatusEnum.INACTIVE);
        List<ReceptionistDTO> receptionistDTOs = receptionists.stream()
                .map(receptionist -> new ReceptionistDTO(
                        receptionist.getId(),
                        receptionist.getName(),
                        receptionist.getSurname(),
                        receptionist.getFiscalCode(),
                        receptionist.getEmail(),
                        receptionist.getTelephoneNumber(),
                        receptionist.getPersonStatusEnum()))
                .collect(Collectors.toList());
        return receptionistDTOs;
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
    public ReceptionistDTO logicalDelete(Long id){
        Receptionist receptionist = receptionistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Secretary not found with id " + id));

        receptionist.setPersonStatusEnum(PersonStatusEnum.INACTIVE);
        Receptionist receptionistDeleted = receptionistRepository.save(receptionist);

        ReceptionistDTO receptionistDTO = new ReceptionistDTO();
        receptionistDTO.setId(receptionistDeleted.getId());
        receptionistDTO.setName(receptionistDeleted.getName());
        receptionistDTO.setSurname(receptionistDeleted.getSurname());
        receptionistDTO.setEmail(receptionistDeleted.getEmail());
        receptionistDTO.setTelephoneNumber(receptionistDeleted.getTelephoneNumber());
        receptionistDTO.setFiscalCode(receptionistDeleted.getFiscalCode());
        receptionistDTO.setPersonStatusEnum(receptionistDeleted.getPersonStatusEnum());

        return receptionistDTO;

    }



    public ReceptionistDTO restoreReceptionist(Long id) throws Exception {
        Receptionist receptionist = receptionistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Secretary not found with id " + id));

        if (receptionist.getPersonStatusEnum() == PersonStatusEnum.INACTIVE){
            receptionist.setPersonStatusEnum(PersonStatusEnum.ACTIVE);
        } else if (receptionist.getPersonStatusEnum() == PersonStatusEnum.ACTIVE) {
            throw new Exception("the secretary is already active");
        }

        Receptionist receptionistDeleted = receptionistRepository.save(receptionist);

        ReceptionistDTO receptionistDTO = new ReceptionistDTO();
        receptionistDTO.setId(receptionistDeleted.getId());
        receptionistDTO.setName(receptionistDeleted.getName());
        receptionistDTO.setSurname(receptionistDeleted.getSurname());
        receptionistDTO.setEmail(receptionistDeleted.getEmail());
        receptionistDTO.setTelephoneNumber(receptionistDeleted.getTelephoneNumber());
        receptionistDTO.setFiscalCode(receptionistDeleted.getFiscalCode());
        receptionistDTO.setPersonStatusEnum(receptionistDeleted.getPersonStatusEnum());

        return receptionistDTO;

    }

}













