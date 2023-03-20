package co.gruppo2.mobs.repositories;

import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;


@RepositoryRestResource
public interface IBookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByBookingStatusEnum(BookingStatusEnum bookingStatusEnum);
    List<Booking> findByDate(LocalDate date);

}
