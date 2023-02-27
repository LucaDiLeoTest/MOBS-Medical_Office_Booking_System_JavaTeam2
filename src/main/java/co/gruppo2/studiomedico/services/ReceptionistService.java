package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.DTO.ReceptionistDTO;
import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.entities.ReceptionistEntity;
import co.gruppo2.studiomedico.enumerations.BookingStatusEnum;
import co.gruppo2.studiomedico.repositories.IBookingRepository;
import co.gruppo2.studiomedico.repositories.IReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    IBookingRepository bookingRepository;


//------------------------------------------Receptionist Logic-------------------------------------------//
    public ReceptionistDTO createAndSaveReceptionist(ReceptionistDTO receptionistDTO){
        ReceptionistEntity receptionist = new ReceptionistEntity();
        receptionist.setName(receptionistDTO.getName());
        receptionist.setSurname(receptionistDTO.getSurname());
        receptionist.setEmail(receptionistDTO.getEmail());
        receptionist.setReceptionistOfficeContact(receptionistDTO.getOfficeContactReceptionist());
        receptionist.setReceptionistWorkPlace(receptionistDTO.getReceptionistWorkPlace());
        receptionistRepository.save(receptionist);
        return new ReceptionistDTO(receptionist.getId(), receptionist.getName(), receptionist.getSurname(),
                receptionist.getEmail(), receptionist.getReceptionistOfficeContact(), receptionist.getReceptionistWorkPlace());
    }

    public Optional<ReceptionistEntity> getReceptionistById(Long id){
        return receptionistRepository.findById(id);
    }
    public List<ReceptionistEntity> getAllReceptionist(){
        return receptionistRepository.findAll();
    }

    public ReceptionistEntity saveOrUpdate(Long id,  String email, String contact, String workPlace){
        ReceptionistEntity receptionist;
        if(receptionistRepository.existsById(id)){
            receptionist = receptionistRepository.getById(id);
            receptionist.setEmail(email);
            receptionist.setReceptionistOfficeContact(contact);
            receptionist.setReceptionistWorkPlace(workPlace);
            return  receptionistRepository.save(receptionist);
        } else {
            receptionist = new ReceptionistEntity();
        }
        return receptionist;
    }

    public void deleteSecretaryById(Long id){
        receptionistRepository.deleteById(id);

    }
    public void deleteAllSecretary(){
        receptionistRepository.deleteAll();

    }

    //-----------------------------------Reservation logic----------------------------------------------//

    public void createAndSaveReservation(Booking booking) {

        booking.setBookingStatusEnum(BookingStatusEnum.CONFIRMED);
        bookingRepository.saveAndFlush(booking);
    }

    public void deleteReservationById(Long id) throws Exception {

        if (bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);
        } else {
            throw new Exception("Reservation not found!");
        }
    }

    public void deleteAllReservations(){
        bookingRepository.deleteAll();
    }

    public List<Booking> getAllReservations(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getReservationById(Long id) throws Exception {
       if (bookingRepository.existsById(id)){
           return bookingRepository.findById(id);
       } else {
           throw new Exception("Reservation not found");
       }

    }


    public Booking updateReservation(Long id, LocalDateTime startTime, LocalDateTime endTime){
        Booking booking;
        if (bookingRepository.existsById(id)){
            booking = bookingRepository.getById(id);
            booking.setStartingTime(startTime);
        //  booking.setEndingTime(endTime);
        } else {

            booking = new Booking();
        }
        booking.setBookingStatusEnum(BookingStatusEnum.MODIFIED);
        booking = bookingRepository.save(booking);
        return booking;
    }

    //-----LOGICAL DELETE AND LOGICAL SET STATUS-------//

    public List<Booking> logicalDelete() {
       List<Booking> reservations = bookingRepository.findAll();

       for (Booking booking: reservations) {
            if (booking.getBookingStatusEnum() != null && booking.getBookingStatusEnum() == BookingStatusEnum.EXPIRED){
                bookingRepository.delete(booking);
            }
        }
            return reservations;
    }

    public List<Booking> logicalSetStatus(){
        LocalDateTime now = LocalDateTime.now();
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking booking : bookings) {
            if (booking.getEndingTime() != null && booking.getEndingTime().isBefore(now)) {
                booking.setBookingStatusEnum(BookingStatusEnum.EXPIRED);
            }
        }
        return bookingRepository.saveAll(bookings);
    }

}











