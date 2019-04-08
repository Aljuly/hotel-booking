package ua.com.foxminded.hotelbooking.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.com.foxminded.hotelbooking.domain.Room;
import ua.com.foxminded.hotelbooking.repository.RoomRepository;

@RestController
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping(value = "/rooms/dates/{from}/{to}", method = RequestMethod.GET)
	public ResponseEntity<?> getRoomByDates(
			@PathVariable("from") @DateTimeFormat(pattern = "ddMMyyy") Date checkIn,
			@PathVariable("to") @DateTimeFormat(pattern = "ddMMyyy") Date ckeckOut) {
		Iterable<Room> allrooms = roomRepository.findByDate(checkIn, ckeckOut);
		
		return new ResponseEntity<>(allrooms, HttpStatus.OK); 
	}

	@RequestMapping(value = "rooms/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRoomsByCategory(@PathVariable("id") Long id) {
		Iterable<Room> allRooms = roomRepository.findByCategory(id);
		return new ResponseEntity<>(allRooms, HttpStatus.OK);
	}
}
