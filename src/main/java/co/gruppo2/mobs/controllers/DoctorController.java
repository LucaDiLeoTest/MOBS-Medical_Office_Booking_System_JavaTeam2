package co.gruppo2.mobs.controllers;


import co.gruppo2.mobs.DTO.DoctorDTO;
import co.gruppo2.mobs.entities.Doctor;
import co.gruppo2.mobs.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/")
    public String doctorMsg(){
        return "You are in the doctor controller!";
    }

    @GetMapping("/all")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id){
        DoctorDTO doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO){
        return doctorService.createDoctor(doctorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO){
        DoctorDTO doctorDTOs = doctorService.updateDoctor(id, doctorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(doctorDTOs);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<DoctorDTO> logicalDelete(@PathVariable Long id){
       DoctorDTO doctorDTO = doctorService.logicalDelete(id);
       return ResponseEntity.ok(doctorDTO);
   }

}
