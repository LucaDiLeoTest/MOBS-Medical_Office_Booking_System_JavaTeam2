package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long>{
}
