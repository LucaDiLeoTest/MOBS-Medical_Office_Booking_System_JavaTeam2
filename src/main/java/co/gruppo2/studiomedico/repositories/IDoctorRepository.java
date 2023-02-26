package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
