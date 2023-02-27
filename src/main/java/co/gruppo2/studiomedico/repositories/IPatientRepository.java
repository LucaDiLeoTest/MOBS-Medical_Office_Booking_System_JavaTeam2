package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long>{
    Optional<Patient> findByEmail(String email);

    Optional<Patient> findById(Long is);

    List<Patient> findByNameAndSurname(String name,String surname);
    void logicalDelete(Long id);
}
