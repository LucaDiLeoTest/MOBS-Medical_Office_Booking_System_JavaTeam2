package co.gruppo2.mobs.controllers;


import co.gruppo2.mobs.DTO.DoctorDTO;
import co.gruppo2.mobs.entities.Doctor;

import co.gruppo2.mobs.repositories.IDoctorRepository;
import co.gruppo2.mobs.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api-doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    IDoctorRepository doctorRepository;

    @GetMapping("/")
    public String doctorMsg(){
        return "You are in the doctor controller!";
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/")
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
