package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.CreationBookingDTO;
import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.entities.Doctor;
import co.gruppo2.mobs.entities.Patient;
import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IDoctorRepository;
import co.gruppo2.mobs.repositories.IPatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private IBookingRepository iBookingRepository;

    @Autowired
    private IDoctorRepository iDoctorRepository;

    @Autowired
    private IPatientRepository iPatientRepository;

    /**
     * This method insert a new Booking in the table
     * @param creationBookingDTO
     * @return
     */
    public String createBooking(CreationBookingDTO creationBookingDTO) {
        Booking booking = new Booking();
        booking.setStartingTime(creationBookingDTO.getStartingTime());
        booking.setDate(creationBookingDTO.getDate());
        booking.setBookingStatusEnum(BookingStatusEnum.PENDING);
        Doctor doctor = iDoctorRepository.findById(creationBookingDTO.getDoctorId()).
                orElseThrow(()-> new EntityNotFoundException("Entity not found"));
        Patient patient = iPatientRepository.findById(creationBookingDTO.getPatientId())
                .orElseThrow(()-> new EntityNotFoundException("Entity not found"));
        booking.setDoctor(doctor);
        booking.setPatient(patient);
        iBookingRepository.save(booking);
        return "Congratulation, the booking has been created successfully!";
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
        existingBooking.setDoctor(booking.getDoctor());
        existingBooking.setPatient(booking.getPatient());
        return iBookingRepository.save(existingBooking);
    }

    /**
     * This method logical delete a booking using its id and setting it's status on DELETED
     * @param id
     */
    public Booking logicalDeleteBooking(long id){
        Booking logicalDeleteBooking = getBookingById(id);
        logicalDeleteBooking.setBookingStatusEnum(BookingStatusEnum.EXPIRED);
        iBookingRepository.save(logicalDeleteBooking);
        System.out.println("The booking " + id + " has been deleted!");
        return logicalDeleteBooking;
    }


}
