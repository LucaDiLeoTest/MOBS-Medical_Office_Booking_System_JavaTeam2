package co.gruppo2.studiomedico.services;

import co.gruppo2.studiomedico.entities.Booking;
import co.gruppo2.studiomedico.repositories.IBookingRepository;
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
    public Booking createBooking (Booking booking){

        return iBookingRepository.save(booking);
    }

    /*public Booking editBooking(Booking booking){

        if(iBookingRepository.existsById(booking.getId())){
            booking = iBookingRepository.getById(booking.getId());      WORK IN PROGRESS...
            LocalDateTime updateStartingTime;
            booking.setStartingTime();


        }else{
            booking = new Booking();
        }
        return booking;
    }*/


    /**
     * This method return the required booking found using its unique id_booking
     * @param id (unique param) use for identifies the required booking
     * @return  the required booking
     */
    public Booking findBookingById(long id){
        return iBookingRepository.existsById(id) ? iBookingRepository.getById(id) : new Booking();
    }

    /**
     * This method return the entire list of booking
     * @return
     */
    public List<Booking> getAllBooking(){
        return iBookingRepository.findAll();
    }



    /**
     * This method delete a booking using its id
     * @param id
     */
    public void deleteBooking(long id){
        iBookingRepository.deleteById(id);
        System.out.println("The booking " + id + " has been deleted! " );
    }


}
