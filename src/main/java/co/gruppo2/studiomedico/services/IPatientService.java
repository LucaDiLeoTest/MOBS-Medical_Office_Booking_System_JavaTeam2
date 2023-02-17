package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientService{
    Patient createAndSavePatient(Patient patient);

    List<Patient> getAllPatient();

    Optional<Patient> findPatientById(Long id);

    void deletePatient(Long patientId);

    void saveOrUpdate(Patient patient);
}
