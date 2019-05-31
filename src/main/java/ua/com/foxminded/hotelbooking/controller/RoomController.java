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
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.foxminded.hotelbooking.domain.Room;
import ua.com.foxminded.hotelbooking.repository.RoomRepository;

@RestController
public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
    @ApiOperation(value = "Retrieves all available roms \r\n" + 
    		"for a given date range")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Body:Room List"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server Error")
    })
	@GetMapping("/rooms/dates/{from}/{to}")
	public ResponseEntity<?> getRoomByDates(
			@ApiParam(value = "Room booked from date", required = true) @PathVariable("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkIn,
			@ApiParam(value = "User id from which user object will retrieve", required = true) @PathVariable("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ckeckOut) {
		Iterable<Room> allrooms = roomRepository.findByDate(checkIn, ckeckOut);
		
		return new ResponseEntity<>(allrooms, HttpStatus.OK); 
	}

    @ApiOperation(value = "Retrieves all available roms \r\n" + 
    		"of a given category")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Body:Room List"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server Error")
    })
	@GetMapping("rooms/{id}")
	public ResponseEntity<?> getRoomsByCategory(@PathVariable("id") Long id) {
		Iterable<Room> allRooms = roomRepository.findByCategory(id);
		return new ResponseEntity<>(allRooms, HttpStatus.OK);
	}
}
