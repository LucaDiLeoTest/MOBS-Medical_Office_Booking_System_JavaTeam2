package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.entities.Receptionist;
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
    public Receptionist createAndSaveReceptionist(Receptionist receptionist){
        return receptionistRepository.saveAndFlush(receptionist);
    }

    public Optional<Receptionist> getReceptionistById(Long id){
        return receptionistRepository.findById(id);
    }
    public List<Receptionist> getAllReceptionist(){
        return receptionistRepository.findAll();
    }

    public Receptionist updateReceptionist(Long id, String name, String surname, String email,
                                           String officeContact, String workPlace){
        Receptionist receptionist;
        if (receptionistRepository.existsById(id)){
            receptionist = receptionistRepository.getReferenceById(id);
            receptionist.setReceptionistName(name);
            receptionist.setReceptionistSurname(surname);
            receptionist.setReceptionistEmail(email);
            receptionist.setReceptionistOfficeContact(officeContact);
            receptionist.setReceptionistWorkplace(workPlace);
            receptionist = receptionistRepository.save(receptionist);
        } else {
            receptionist = new Receptionist();
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
        bookingRepository.saveAndFlush(booking);
    }

    public void deleteReservationById(Long id){
        bookingRepository.deleteById(id);
    }

    public void deleteAllReservations(){
        bookingRepository.deleteAll();
    }

    public List<Booking> getAllReservations(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> getReservationById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking updateReservation(Long id, LocalDateTime startTime, LocalDateTime endTime){
        Booking booking;
        if (bookingRepository.existsById(id)){
            booking = bookingRepository.getById(id);
            booking.setStartingTime(startTime);
            booking.setEndingTime(endTime);
            booking = bookingRepository.save(booking);
        } else {
            booking = new Booking();
        }
        return booking;
    }


}
