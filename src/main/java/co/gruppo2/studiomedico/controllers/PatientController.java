package co.gruppo2.studiomedico.controllers;

import co.gruppo2.studiomedico.entities.Patient;
import co.gruppo2.studiomedico.services.PatientService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController{
    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient){
        patientService.createAndSavePatient(patient);
        return patient;
    }

    @GetMapping("/all")
    public List<Patient> getPatients(){
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public Patient getSinglePatient(@PathVariable Long id){
        return patientService.findPatientById(id);
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestParam Long id,@RequestParam String name,@RequestParam String surname,
                                 @RequestParam String email,@RequestParam String contact){
        return patientService.saveOrUpdate(id,name,surname,email,contact);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return "The patient has been deleted!";
    }
    @DeleteMapping("delete/all")
    public String deleteAll(){
       return patientService.deleteAllPatient();
    }
}
