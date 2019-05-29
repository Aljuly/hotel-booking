package ua.com.foxminded.hotelbooking.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ua.com.foxminded.hotelbooking.domain.Booking;
import ua.com.foxminded.hotelbooking.dto.BookingDto;
import ua.com.foxminded.hotelbooking.repository.BookingRepository;
import ua.com.foxminded.hotelbooking.utils.TimeProvider;

@RestController
public class BookingController {
	
	@Autowired
	private TimeProvider timeProvider;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Booking>> getHotelBookings () {
		return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bookings/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserBookings(@PathVariable Long userId) {
		Iterable<Booking> bookings = bookingRepository.findUserBooking(userId);
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public ResponseEntity<?> createBooking(@Valid @RequestBody BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setUsers(Stream.of(bookingDto.getUser()).collect(Collectors.toCollection(HashSet::new)));
		booking.setBookingDates(bookingDto.getBookingDates());
		booking.setBookedRoom(bookingDto.getRoom());
		booking.setOptions(bookingDto.getOptions());
		booking.setDateCreated(timeProvider.localDateTime());
		bookingRepository.save(booking);
		// Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newBookingUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/bookings/{bookingId}")
                .buildAndExpand(booking.getId())
                .toUri();
        responseHeaders.setLocation(newBookingUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}


}
