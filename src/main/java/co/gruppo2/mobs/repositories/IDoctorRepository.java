package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Doctor;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByPersonStatusEnum(PersonStatusEnum personStatusEnum);

}
