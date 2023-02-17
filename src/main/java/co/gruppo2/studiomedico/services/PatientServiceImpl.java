package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Patient;
import co.gruppo2.studiomedico.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientServiceImpl implements IPatientService{
    @Autowired
    IPatientRepository iPatientRepository;

    @Override
    public Patient createAndSavePatient(Patient patient){
        return iPatientRepository.saveAndFlush(patient);
    }

    @Override
    public List<Patient> getAllPatient(){
        return iPatientRepository.findAll();
    }

    @Override
    public Optional<Patient> findPatientById(Long id){
        return iPatientRepository.findById(id);
    }

    @Override
    public void deletePatient(Long patientId){
    iPatientRepository.deleteById(patientId);
    }

    @Override
    public void saveOrUpdate(Patient patient){
iPatientRepository.save(patient);
    }
}
