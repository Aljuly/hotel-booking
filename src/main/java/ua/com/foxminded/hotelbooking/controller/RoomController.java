package ua.com.foxminded.hotelbooking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.foxminded.hotelbooking.domain.Room;
import ua.com.foxminded.hotelbooking.repository.RoomRepository;

@RestController
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
    @ApiOperation(value = "Retrieves an existing User")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Body: User data"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server Error")
    })
	@GetMapping("/rooms/dates/{from}/{to}")
	public ResponseEntity<?> getRoomByDates(
			@PathVariable("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkIn,
			@PathVariable("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ckeckOut) {
		Iterable<Room> allrooms = roomRepository.findByDate(checkIn, ckeckOut);
		
		return new ResponseEntity<>(allrooms, HttpStatus.OK); 
	}

    @ApiOperation(value = "Retrieves an existing User")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Body: User data"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server Error")
    })
	@GetMapping("rooms/{id}")
	public ResponseEntity<?> getRoomsByCategory(@PathVariable("id") Long id) {
		Iterable<Room> allRooms = roomRepository.findByCategory(id);
		return new ResponseEntity<>(allRooms, HttpStatus.OK);
	}
}
