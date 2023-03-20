package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.BookingResponseDTO;
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
import java.util.Optional;

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
    public BookingResponseDTO createBooking(CreationBookingDTO creationBookingDTO) {
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
        return new BookingResponseDTO(booking.getId(), booking.getStartingTime(), booking.getEndingTime(),
                booking.getDate(), booking.getBookingStatusEnum(), booking.getDoctor().getName()+" "+
                booking.getDoctor().getSurname(), booking.getPatient().getName()+" "
                +booking.getPatient().getSurname(), booking.getPatient().getEmail(),
                booking.getPatient().getTelephoneNumber(), booking.getPatient().getFiscalCode());
    }


    /**
     * This method return the required booking found using its unique id_booking
     * @param id (unique param) use for identifies the required booking
     * @return  the required booking
     */
    public BookingResponseDTO getBookingById(Long id) throws EntityNotFoundException{
        Optional<Booking> booking = iBookingRepository.findById(id);
        Optional<BookingResponseDTO> bookingResponseDTO = Optional.empty();
        if(booking.isPresent()){
            bookingResponseDTO = Optional.of(new BookingResponseDTO(booking.get().getId(), booking.get().getStartingTime(), booking.get().getEndingTime(),
                    booking.get().getDate(), booking.get().getBookingStatusEnum(), booking.get().getDoctor().getName()+" "+
                    booking.get().getDoctor().getSurname(), booking.get().getPatient().getName()+" "
                    +booking.get().getPatient().getSurname(), booking.get().getPatient().getEmail(),
                    booking.get().getPatient().getTelephoneNumber(), booking.get().getPatient().getFiscalCode()));
        }else{
            new EntityNotFoundException("Booking not found");
        }
        return bookingResponseDTO.get();
    }

    /**
     * This method return the entire list of booking
     * @return
     */
    public List<Booking> getAllBooking(){
        return iBookingRepository.findAll();
    }

/*    public List<Booking> getAllDailyBooking(){
        List<Booking> dailyBookings = new ArrayList<>();
        iBookingRepository.findAll().forEach(booking ->
                if(booking.getBookingStatusEnum() == BookingStatusEnum.CONFIRMED))
        return dailyBookings;
    }
*/
/*    public List<Booking> checkAllExpiredBookings(){
        iBookingRepository.findAll();
    //recupero prenotazioni < localdate.now()
    //settare tutte le booking su expired
        return ;
    }
*/

    /**
     * This method consent to update an existing booking
     * @param id
     * @param updateBookingDTO
     * @return
     */
    public BookingResponseDTO updateBooking(Long id, UpdateBookingDTO updateBookingDTO) {
        Booking booking = iBookingRepository.findById(id).get();
        if(updateBookingDTO.getStartingTime() != null){
            booking.setStartingTime(updateBookingDTO.getStartingTime());
        }
        if(updateBookingDTO.getEndingTime() != null){
            booking.setEndingTime(updateBookingDTO.getEndingTime());
        }
        if(updateBookingDTO.getDate() != null){
            booking.setDate(updateBookingDTO.getDate());
        }
        if(updateBookingDTO.getBookingStatusEnum() != null){
            booking.setBookingStatusEnum(updateBookingDTO.getBookingStatusEnum());
        }
        iBookingRepository.save(booking);
        return new BookingResponseDTO(booking.getId(), booking.getStartingTime(), booking.getEndingTime(),
                booking.getDate(), booking.getBookingStatusEnum(), booking.getDoctor().getName()+" "+
                booking.getDoctor().getSurname(), booking.getPatient().getName()+" "
                +booking.getPatient().getSurname(), booking.getPatient().getEmail(),
                booking.getPatient().getTelephoneNumber(), booking.getPatient().getFiscalCode());
    }

    /**
     * This method logical delete a booking using its id and setting it's status on DELETED
     * @param id
     */
    public void logicalDeleteBooking(long id){
        Optional<Booking> booking = iBookingRepository.findById(id);
        if(booking.isPresent()){
        booking.get().setBookingStatusEnum(BookingStatusEnum.EXPIRED);
        iBookingRepository.save(booking.get());
        }

    }


}
