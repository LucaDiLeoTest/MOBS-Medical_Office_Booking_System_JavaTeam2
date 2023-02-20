package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceptionistRepository extends JpaRepository<Receptionist, Long> {
}
