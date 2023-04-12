package co.gruppo2.mobs.controllers;

import co.gruppo2.mobs.DTO.PatientDTO;
import co.gruppo2.mobs.services.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/patient")
public class PatientController{
    @Autowired
    private PatientService patientService;


    @PostMapping("/add")//TODO fare in modo che l' utente non veda l'enum Active/Inactive
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatientDTO> createPatientDTO(@RequestBody PatientDTO patientDTO)
            throws JsonProcessingException{
        PatientDTO savedPatient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(savedPatient,HttpStatus.CREATED);
    }


    @GetMapping("/email/{email}")//TODO nel caso di null da un 500 e non viene gestito l' errore
    public ResponseEntity<PatientDTO> findPatientByEmail(@PathVariable String email) throws Exception{
        PatientDTO patientDTO = patientService.findPatientByEmail(email);
        if(patientDTO.getEmail().equals(email)){
            return ResponseEntity.ok(patientDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientDTO);
        }
    }


    @GetMapping("/id/{id}")//TODO nel caso di null da un 500 e non viene gestito l' errore
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Long id){
        PatientDTO patientDTO = patientService.findPatientById(id);
        if(!Objects.equals(patientDTO.getId(),id)){
            return ResponseEntity.ok(patientDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientDTO);
        }
    }

    @GetMapping("/name-surname")
    public ResponseEntity<PatientDTO> findPatientsByNameSurname(@RequestParam String name,@RequestParam String surname){
        PatientDTO patientsDTO = patientService.findPatientsByNameSurname(name,surname);
        if(patientsDTO.getId() != null){
            return ResponseEntity.ok(patientsDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(patientsDTO);
        }
    }

    @DeleteMapping("/id/{id}")//TODO fare in modo che l' utente non veda l'enum Active/Inactive
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.logicalDeletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
