package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.DoctorDTO;
import co.gruppo2.mobs.entities.Doctor;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IDoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DoctorService {

    @Autowired
    IDoctorRepository doctorRepository;

    @Autowired
    IBookingRepository bookingRepository;


    /**
     Creates a new doctor in the system and returns the DTO representation of the created doctor.
     @param doctorDTO the DoctorDTO object representing the doctor to be created
     @return the DoctorDTO object representing the created doctor, including the assigned ID
     @throws IllegalArgumentException if the provided DoctorDTO object is null
     */
    public DoctorDTO createDoctor(@NotNull DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setFiscalCode(doctorDTO.getFiscalCode());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPersonStatusEnum(PersonStatusEnum.ACTIVE);
        doctorRepository.save(doctor);
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getFiscalCode(), doctor.getEmail(), doctor.getPersonStatusEnum());
    }

    /**
     Finds a doctor in the system by their ID and returns the Doctor object.
     @param id the ID of the doctor to find
     @return the Doctor object representing the found doctor
     */
public DoctorDTO getDoctorById(Long id){
    Optional<Doctor> doctor = doctorRepository.findById(id);
    if (doctor.isPresent()){
        Doctor d = doctor.get();

        if (d.getPersonStatusEnum() == PersonStatusEnum.INACTIVE){
            throw new EntityNotFoundException("Doctor with id " + id + " is inactive");
        }

        return new DoctorDTO(
                doctor.get().getId(),
                doctor.get().getName(),
                doctor.get().getSurname(),
                doctor.get().getFiscalCode(),
                doctor.get().getEmail(),
                doctor.get().getPersonStatusEnum()
        );
    } else {
        throw new EntityNotFoundException("Doctor not found with id " + id);
    }
}

    /**
     Finds all doctors in the system and returns a list of Doctor objects.
     @return a List of Doctor objects representing all the doctors in the system
     */
    public List<DoctorDTO> getAllDoctors(){

        List<Doctor> doctors = doctorRepository.findByPersonStatusEnum(PersonStatusEnum.ACTIVE);
        List<DoctorDTO> doctorDTOs = doctors.stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSurname(),
                        doctor.getEmail(),
                        doctor.getFiscalCode(),
                        doctor.getPersonStatusEnum()))
                .collect(Collectors.toList());

        return doctorDTOs;

    }

    /**
     Updates the information of an existing doctor in the system and returns the DTO representation of the updated doctor.
     @param id the ID of the doctor to update
     @param doctorDTO the DoctorDTO object representing the updated information for the doctor
     @return the DoctorDTO object representing the updated doctor
     */
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.getById(id);
        if (doctorDTO.getId() != null) {
           doctorDTO.getId();
        }

        if (doctorDTO.getName() != null) {
            doctor.setName(doctorDTO.getName());
        }
        if (doctorDTO.getSurname() != null) {
            doctor.setSurname(doctorDTO.getSurname());
        }
        if (doctorDTO.getFiscalCode() != null) {
            doctor.setFiscalCode(doctorDTO.getFiscalCode());
        }
        if (doctorDTO.getEmail() != null) {
            doctor.setEmail(doctorDTO.getEmail());
        }
        doctorRepository.save(doctor);
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSurname(), doctor.getEmail(), doctor.getFiscalCode(), doctor.getPersonStatusEnum());
    }

    /**
     * Sets the PersonStatusEnum to inactive for the logical deletion
     * @param id
     */

    public DoctorDTO logicalDelete(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + id));


        doctor.setPersonStatusEnum(PersonStatusEnum.INACTIVE);
        Doctor doctorDeleted = doctorRepository.save(doctor);

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctorDeleted.getId());
        doctorDTO.setName(doctorDeleted.getName());
        doctorDTO.setSurname(doctorDeleted.getSurname());
        doctorDTO.setEmail(doctorDeleted.getEmail());
        doctorDTO.setFiscalCode(doctorDeleted.getFiscalCode());
        doctorDTO.setPersonStatusEnum(doctorDeleted.getPersonStatusEnum());

        return doctorDTO;
    }

}
