package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Patient;
import co.gruppo2.studiomedico.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService{
    @Autowired
    IPatientRepository iPatientRepository;

    public Patient createAndSavePatient(Patient patient){
        return iPatientRepository.save(patient);
    }


    public List<Patient> getAllPatient(){
        return iPatientRepository.findAll();
    }


    public Patient findPatientById(Long id){
        return iPatientRepository.existsById(id) ? iPatientRepository.getById(id) : new Patient();
    }

    public Patient saveOrUpdate(Long id,String name,String surname,String email,String contact){
        Patient patient;
        if(iPatientRepository.existsById(id)){
            patient = iPatientRepository.getById(id);
            patient.setName(name);
            patient.setSurname(surname);
            patient.setEmail(email);
            patient.setContact(contact);
            patient = iPatientRepository.save(patient);
        } else {
            patient = new Patient();
        }
        return patient;
    }

    public String deletePatientById(Long id){
        iPatientRepository.deleteById(id);
        return "The patient "+id+" has been eliminated";
    }

    public String deleteAllPatient(){
        iPatientRepository.deleteAll();
        return "All the patients have been deleted!";
    }
}
