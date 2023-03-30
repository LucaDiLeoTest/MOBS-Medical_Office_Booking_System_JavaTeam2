package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.enumerations.PersonStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IReceptionistRepository extends JpaRepository<Receptionist, Long> {

    List<Receptionist>findByPersonStatusEnum(PersonStatusEnum personStatusEnum);
}
