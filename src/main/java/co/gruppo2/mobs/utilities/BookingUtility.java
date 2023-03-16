package co.gruppo2.mobs.utilities;

import co.gruppo2.mobs.repositories.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingUtility {
    @Autowired
    IBookingRepository iBookingRepository;

    public void checkBookingStatus(){

    }
}
