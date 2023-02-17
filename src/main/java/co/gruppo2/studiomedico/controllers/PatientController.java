package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.entities.Patient;
import co.gruppo2.studiomedico.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class PatientController{
    @Autowired
    PatientServiceImpl patientService;
    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient){
        patientService.createAndSavePatient(patient);
        return patient;
    }
}
