package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.entities.ReceptionistEntity;
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
    public ReceptionistEntity createAndSaveReceptionist(ReceptionistEntity receptionist){
        return receptionistRepository.saveAndFlush(receptionist);
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
            receptionist.setReceptionistWorkplace(workPlace);
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
