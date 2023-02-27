package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.DTO.PatientDTO;
import co.gruppo2.studiomedico.entities.Patient;
import co.gruppo2.studiomedico.enumerations.PersonStatusEnum;
import co.gruppo2.studiomedico.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    private IPatientRepository patientRepository;



    public PatientDTO createPatient(PatientDTO patientDTO){
        Patient patient = convertToEntity(patientDTO);
        patient.setPersonStatusEnum(PersonStatusEnum.ACTIVE);
        patientRepository.save(patient);
        patientDTO.setId(patient.getId());
        return patientDTO;
    }



    public PatientDTO findPatientByEmail(String email) throws Exception{
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);
        if(!patientOptional.isPresent()){
            throw new Exception("Patient not found with email: "+email);
        } else {
            Patient patient = patientOptional.get();
            return new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getEmail(),
                    patient.getTelephoneNumber());
        }
    }


    public PatientDTO findPatientById(Long id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(!patientOptional.isPresent()){
            throw new NullPointerException("Patient not found with id: "+id);
        } else {
            Patient patient = patientOptional.get();
            return new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getEmail(),
                    patient.getTelephoneNumber());
        }
    }

    public List<PatientDTO> findPatientsByNameSurname(String name,String surname){
        List<Patient> patients = patientRepository.findByNameAndSurname(name,surname);
        List<PatientDTO> patientsDTO = new ArrayList<>();
        for(Patient patient : patients){
            patientsDTO.add(new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getEmail(),
                    patient.getTelephoneNumber()));
        }
        return patientsDTO;
    }
    public void logicalDeletePatientById(Long id){
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setPersonStatusEnum(PersonStatusEnum.INACTIVE);
            patientRepository.save(patient);
        }
    }

    private Patient convertToEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setEmail(patientDTO.getEmail());
        patient.setTelephoneNumber(patientDTO.getTelephoneNumber());
        return patient;
    }
}
