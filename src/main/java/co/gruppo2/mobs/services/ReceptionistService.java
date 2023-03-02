package co.gruppo2.mobs.services;

import co.gruppo2.mobs.DTO.ReceptionistDTO;
import co.gruppo2.mobs.entities.Booking;
import co.gruppo2.mobs.entities.Receptionist;
import co.gruppo2.mobs.enumerations.BookingStatusEnum;
import co.gruppo2.mobs.repositories.IBookingRepository;
import co.gruppo2.mobs.repositories.IReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService{

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    IBookingRepository bookingRepository;


//------------------------------------------Receptionist Logic-------------------------------------------//

    /**
     * Creates and saves a new receptionist entity with the given receptionistDTO
     *
     * @param receptionistDTO The DTO containing the receptionist's data
     * @return The saved receptionist DTO
     */
    public ReceptionistDTO createAndSaveReceptionist(ReceptionistDTO receptionistDTO){
        Receptionist receptionist = new Receptionist();
        receptionist.setName(receptionistDTO.getName());
        receptionist.setSurname(receptionistDTO.getSurname());
        receptionist.setEmail(receptionistDTO.getEmail());
        receptionistRepository.save(receptionist);
        return new ReceptionistDTO(receptionist.getId(),receptionist.getName(),receptionist.getSurname(),
                receptionist.getEmail());
    }

    /**
     * Retrieves a receptionist entity by its id
     *
     * @param id The id of the receptionist to retrieve
     * @return An optional containing the receptionist entity if found, empty otherwise
     */
    public Optional<Receptionist> getReceptionistById(Long id){
        return receptionistRepository.findById(id);
    }

    /**
     * Retrieves all receptionist entities
     *
     * @return A list containing all receptionist entities
     */
    public List<Receptionist> getAllReceptionist(){
        return receptionistRepository.findAll();
    }


    /**
     * Saves or updates a receptionist entity with the given data
     *
     * @param id        The id of the receptionist to save or update
     * @param email     The new email to set for the receptionist
     * @param contact   The new contact information to set for the receptionist
     * @param workPlace The new work place to set for the receptionist
     * @return The saved or updated receptionist entity
     */
    public Receptionist saveOrUpdate(Long id, String email, String contact, String workPlace){
        Receptionist receptionist;
        if(receptionistRepository.existsById(id)){
            receptionist = receptionistRepository.getById(id);
            receptionist.setEmail(email);
            return receptionistRepository.save(receptionist);
        } else {
            receptionist = new Receptionist();
        }
        return receptionist;
    }


    /**
     * Deletes a receptionist entity by its id
     *
     * @param id The id of the receptionist to delete
     */
    public void deleteSecretaryById(Long id){
        receptionistRepository.deleteById(id);

    }

    /**
     * Deletes all receptionist entities
     */
    public void deleteAllSecretary(){
        receptionistRepository.deleteAll();

    }

    //-----------------------------------Reservation logic----------------------------------------------//

    /**
     * Creates and saves a new reservation with the given booking information
     *
     * @param booking The booking information for the reservation
     */
    public void createAndSaveReservation(Booking booking){
        booking.setBookingStatusEnum(BookingStatusEnum.CONFIRMED);
        bookingRepository.saveAndFlush(booking);
    }

    /**
     * Deletes a reservation by its id
     *
     * @param id The id of the reservation to delete
     * @throws Exception If the reservation is not found
     */
    public void deleteReservationById(Long id) throws Exception{
        if(bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);
        } else {
            throw new Exception("Reservation not found!");
        }
    }

    /**
     * Deletes all reservations
     */
    public void deleteAllReservations(){
        bookingRepository.deleteAll();
    }


    /**
     * Retrieves all reservations
     *
     * @return A list containing all reservations
     */
    public List<Booking> getAllReservations(){
        return bookingRepository.findAll();
    }


    /**
     * Retrieves a reservation by its id
     *
     * @param id The id of the reservation to retrieve
     * @return An optional containing the reservation if found, empty otherwise
     * @throws Exception If the reservation is not found
     */
    public Optional<Booking> getReservationById(Long id) throws Exception{
        if(bookingRepository.existsById(id)){
            return bookingRepository.findById(id);
        } else {
            throw new Exception("Reservation not found");
        }

    }


    /**
     * Updates a reservation's starting time and sets its status to "modified"
     *
     * @param id        The id of the reservation to update
     * @param startTime The new starting time to set for the reservation
     * @return The updated reservation
     */
    public Booking updateReservation(Long id,LocalDateTime startTime,LocalDateTime endTime){
        Booking booking;
        if(bookingRepository.existsById(id)){
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

    /**
     * Deletes all reservations with a status of "expired"
     *
     * @return A list containing all reservations, including those deleted
     */
    public List<Booking> logicalDelete(){
        List<Booking> reservations = bookingRepository.findAll();

        for(Booking booking : reservations){
            if(booking.getBookingStatusEnum() != null && booking.getBookingStatusEnum() == BookingStatusEnum.EXPIRED){
                bookingRepository.delete(booking);
            }
        }
        return reservations;
    }


    /**
     * Sets the status of all reservations that have already ended to "expired"
     *
     * @return A list containing all updated reservations
     */
    public List<Booking> logicalSetStatus(){
        LocalDateTime now = LocalDateTime.now();
        List<Booking> bookings = bookingRepository.findAll();
        for(Booking booking : bookings){
            if(booking.getEndingTime() != null && booking.getEndingTime().isBefore(now)){
                booking.setBookingStatusEnum(BookingStatusEnum.EXPIRED);
            }
        }
        return bookingRepository.saveAll(bookings);
    }

}











