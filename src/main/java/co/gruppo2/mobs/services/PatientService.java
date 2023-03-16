package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.PatientDTO;
import co.gruppo2.mobs.entities.Patient;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import co.gruppo2.mobs.repositories.IPatientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Creates a new patient in the system and returns the DTO representation of the created patient.
     * The provided PatientDTO object is converted to a JSON string and then deserialized back into a Patient object,
     * which is then saved to the patientRepository with a PersonStatusEnum of ACTIVE.
     *
     * @param patientDTO the PatientDTO object representing the patient to be created
     * @return the PatientDTO object representing the created patient, including the assigned ID
     * @throws JsonProcessingException if there is an error converting the PatientDTO object to a JSON string
     */
    public PatientDTO createPatient(PatientDTO patientDTO) throws JsonProcessingException{
        String jsonPatient = objectMapper.writeValueAsString(patientDTO);
        Patient patient = objectMapper.readValue(jsonPatient,Patient.class);
        patient.setPersonStatusEnum(PersonStatusEnum.ACTIVE);
        patientRepository.save(patient);
        patientDTO.setId(patient.getId());
        return patientDTO;
    }


    /**
     * Finds a patient in the system by their email address and returns the DTO representation of the patient.
     *
     * @param email the email address of the patient to find
     * @return the PatientDTO object representing the found patient
     * @throws Exception if no patient is found with the provided email address
     */
    public PatientDTO findPatientByEmail(String email) throws Exception{
        Optional<Patient> patientOptional = patientRepository.findByEmail(email);
        if(!patientOptional.isPresent()|| (patientOptional.get().getPersonStatusEnum().equals(PersonStatusEnum.ACTIVE))){
            throw new Exception("Patient not found with email: "+email);
        } else {
            Patient patient = patientOptional.get();
            return new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getFiscalCode(),patient.getEmail(),
                    patient.getTelephoneNumber());
        }
    }

    /**
     * Finds a patient in the system by their ID and returns the DTO representation of the patient.
     *
     * @param id the ID of the patient to find
     * @return the PatientDTO object representing the found patient
     * @throws NullPointerException if no patient is found with the provided ID
     */
    public PatientDTO findPatientById(Long id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(!patientOptional.isPresent() || (patientOptional.get().getPersonStatusEnum().equals(PersonStatusEnum.INACTIVE))){
            throw new NullPointerException("Patient not found with id: "+id);
        } else {
            Patient patient = patientOptional.get();
            return new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getFiscalCode(),patient.getEmail(),
                    patient.getTelephoneNumber());
        }
    }

    /**
     * Finds all patients in the system with the provided name and surname, and returns a list of their DTO representations.
     *
     * @param name    the name of the patients to find
     * @param surname the surname of the patients to find
     * @return a List of PatientDTO objects representing the found patients
     */
    public List<PatientDTO> findPatientsByNameSurname(String name,String surname){
        List<Patient> patients = patientRepository.findByNameAndSurname(name,surname);
        List<PatientDTO> patientsDTO = new ArrayList<>();
        for(Patient patient : patients){
            patientsDTO.add(new PatientDTO(patient.getId(),patient.getName(),patient.getSurname(),patient.getFiscalCode(),patient.getEmail(),
                    patient.getTelephoneNumber()));
        }
        return patientsDTO;//TODO Fix this problem for inactive patient
    }

    /**
     * Sets the status of a patient with the provided ID to INACTIVE in the patientRepository.
     *
     * @param id the ID of the patient to delete
     */
    public void logicalDeletePatientById(Long id){
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setPersonStatusEnum(PersonStatusEnum.INACTIVE);
            patientRepository.save(patient);
        }
    }

    /**
     * Converts a PatientDTO object to a Patient object (deprecated).
     *
     * @param patientDTO the PatientDTO object to convert
     * @return the Patient object representing the same patient as the provided PatientDTO object
     */
    @Deprecated
    private Patient convertToEntity(PatientDTO patientDTO){
        if(patientDTO==null)return null;
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setSurname(patientDTO.getSurname());
        patient.setEmail(patientDTO.getEmail());
        patient.setTelephoneNumber(patientDTO.getTelephoneNumber());
        return patient;
    }
}
