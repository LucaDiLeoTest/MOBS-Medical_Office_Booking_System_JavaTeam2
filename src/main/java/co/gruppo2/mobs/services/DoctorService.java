package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.DoctorDTO;
import co.gruppo2.mobs.entities.Doctor;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IDoctorRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        doctor.setEmail(doctorDTO.getEmail());
        doctorRepository.save(doctor);
        return new DoctorDTO(doctor.getId(), doctorDTO.getName(), doctorDTO.getSurname(), doctor.getEmail());
    }

    /**
     Finds a doctor in the system by their ID and returns the Doctor object.
     @param id the ID of the doctor to find
     @return the Doctor object representing the found doctor
     */
    public Doctor getDoctorById(Long id){
        return doctorRepository.getById(id);
    }

    /**
     Finds all doctors in the system and returns a list of Doctor objects.
     @return a List of Doctor objects representing all the doctors in the system
     */
    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    /**
     Updates the information of an existing doctor in the system and returns the DTO representation of the updated doctor.
     @param id the ID of the doctor to update
     @param doctorDTO the DoctorDTO object representing the updated information for the doctor
     @return the DoctorDTO object representing the updated doctor
     */
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO){
        Doctor doctor = getDoctorById(id);
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setEmail(doctorDTO.getEmail());
        doctorRepository.save(doctor);
        return doctorDTO;
    }

}
