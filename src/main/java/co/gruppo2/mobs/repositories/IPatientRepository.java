package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Patient;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface IPatientRepository extends JpaRepository<Patient,Long>{
    Optional<Patient> findByEmail(String email);

Optional<Patient> findById(Long id);

    List<Patient> findByNameAndSurname(String name,String surname);
}
