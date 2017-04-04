package com.wkp.controller;

import com.wkp.entity.HotelBooking;
import com.wkp.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/booking")
@Api(name = "hotel booking api", description = "provide a list of methods", stage = ApiStage.RC)
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hot booking from the database")
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hot booking where <=price")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "new booking")
    public boolean create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return true;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "delete booking")
    public boolean delete(@ApiPathParam(name = "id", description = "booking id") @PathVariable long id) {
        bookingRepository.delete(id);
        return true;
    }
}
