package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceptionistRepository extends JpaRepository<Receptionist, Long> {
}
