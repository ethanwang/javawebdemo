
package com.wkp.repository;

import com.wkp.entity.HotelBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository  extends JpaRepository<HotelBooking, Long> {
 
     public List<HotelBooking> findByPricePerNightLessThan(double price);
     
}
