package co.gruppo2.mobs.services;

import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private IBookingRepository iBookingRepository;

    /**
     * This method insert a new Booking in the table
     * @param booking
     * @return
     */
    public Booking createBooking(Booking booking) {
        return iBookingRepository.save(booking);
    }
    /**
     * This method return the required booking found using its unique id_booking
     * @param id (unique param) use for identifies the required booking
     * @return  the required booking
     */
    public Booking getBookingById(Long id) {
        return iBookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking with id " + id + " not found"));
    }

    /**
     * This method return the entire list of booking
     * @return
     */
    public List<Booking> getAllBooking(){
        return iBookingRepository.findAll();
    }


    /**
     * This method consent to update an existing booking
     * @param id
     * @param booking
     * @return
     */
    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setStartingTime(booking.getStartingTime());
        existingBooking.setBookingStatusEnum(booking.getBookingStatusEnum());
        existingBooking.setDoctor1(booking.getDoctor1());
        existingBooking.setPatient(booking.getPatient());
        return iBookingRepository.save(existingBooking);
    }

    /**
     * This method logical delete a booking using its id and setting it's status on DELETED
     * @param id
     */
    public void logicalDeleteBooking(long id){
        Booking logicalDeleteBooking = getBookingById(id);
        logicalDeleteBooking.setBookingStatusEnum(BookingStatusEnum.DELETED);
        iBookingRepository.save(logicalDeleteBooking);
        System.out.println("The booking " + id + " has been deleted!");
    }


}
