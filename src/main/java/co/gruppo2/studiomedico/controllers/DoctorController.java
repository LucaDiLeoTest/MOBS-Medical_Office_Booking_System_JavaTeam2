package co.gruppo2.studiomedico.controllers;


import co.gruppo2.studiomedico.DTO.DoctorDTO;
import co.gruppo2.studiomedico.entities.Doctor;

import co.gruppo2.studiomedico.repositories.IDoctorRepository;
import co.gruppo2.studiomedico.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    IDoctorRepository doctorRepository;

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @GetMapping("")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("")
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO){
        return doctorService.createDoctor(doctorDTO);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO){
        doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id){
        doctorRepository.deleteById(id);
    }

}
