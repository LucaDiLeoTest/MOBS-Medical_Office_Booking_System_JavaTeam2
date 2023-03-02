package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

}
