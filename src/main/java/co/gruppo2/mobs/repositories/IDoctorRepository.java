package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {

}
