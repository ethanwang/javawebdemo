
package com.wkp.repository;

import com.wkp.entity.HotelBooking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Override
    public void run(String... strings) throws Exception {
         List<HotelBooking> bookings=new ArrayList( Arrays.asList(
            new HotelBooking("Marriot", 200.50, 3),
            new HotelBooking("Ibis", 90, 4),           
            new HotelBooking("Movotel", 140.74, 1) 
            ));
         bookingRepository.save(bookings);
         
    }
    
    
}
