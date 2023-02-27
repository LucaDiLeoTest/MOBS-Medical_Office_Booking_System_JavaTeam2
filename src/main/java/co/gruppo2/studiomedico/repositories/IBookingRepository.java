package co.gruppo2.studiomedico.repositories;

import co.gruppo2.studiomedico.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

}
