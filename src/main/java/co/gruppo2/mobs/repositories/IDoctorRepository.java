package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
