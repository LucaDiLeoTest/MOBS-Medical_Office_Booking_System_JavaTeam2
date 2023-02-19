package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepository extends JpaRepository<Booking,Long> {

}
