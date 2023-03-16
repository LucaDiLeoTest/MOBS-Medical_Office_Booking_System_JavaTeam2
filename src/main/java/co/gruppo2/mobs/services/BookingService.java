package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.CreationBookingDTO;
import co.gruppo2.mobs.DTO.UpdateBookingDTO;
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
        return "Congratulation your booking has been created successfully!";
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
        return iBookingRepository.findByBookingStatusEnum(BookingStatusEnum.CONFIRMED);
    }


    /**
     * This method consent to update an existing booking
     * @param id
     * @param updateBookingDTO
     * @return
     */
    public String updateBooking(Long id, UpdateBookingDTO updateBookingDTO) {
        Booking booking = getBookingById(id);
        if(updateBookingDTO.getStartingTime() != null){booking.setStartingTime(updateBookingDTO.getStartingTime());}
        if(updateBookingDTO.getEndingTime() != null){booking.setEndingTime(updateBookingDTO.getEndingTime());}
        if(updateBookingDTO.getDate() != null){booking.setDate(updateBookingDTO.getDate());}
        if(updateBookingDTO.getBookingStatusEnum() != null){booking.setBookingStatusEnum(updateBookingDTO.getBookingStatusEnum());}
        iBookingRepository.save(booking);
        return "Your booking  has been update successfully!";
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
