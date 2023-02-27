package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.DTO.DoctorDTO;
import co.gruppo2.studiomedico.entities.Doctor;
import co.gruppo2.studiomedico.repositories.IBookingRepository;
import co.gruppo2.studiomedico.repositories.IDoctorRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {

    @Autowired
    IDoctorRepository doctorRepository;

    @Autowired
    IBookingRepository bookingRepository;

    public DoctorDTO createDoctor(@NotNull DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setEmail(doctorDTO.getEmail());
        doctorRepository.save(doctor);
        return new DoctorDTO(doctor.getId(), doctorDTO.getName(), doctorDTO.getSurname(), doctor.getEmail());
    }

    public Doctor getDoctorById(Long id){
        return doctorRepository.getById(id);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO){
        Doctor doctor = getDoctorById(id);
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setEmail(doctorDTO.getEmail());
        doctorRepository.save(doctor);
        return doctorDTO;
    }

    public void deleteDoctorById(Long id){

    }
}
