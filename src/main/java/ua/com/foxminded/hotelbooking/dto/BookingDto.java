package ua.com.foxminded.hotelbooking.dto;

import java.util.Set;

import lombok.Data;
import ua.com.foxminded.hotelbooking.domain.BookingDates;
import ua.com.foxminded.hotelbooking.domain.Option;
import ua.com.foxminded.hotelbooking.domain.Room;
import ua.com.foxminded.hotelbooking.domain.User;

@Data
public class BookingDto {
	private User user;
	private Room room;
	private BookingDates bookingDates;
	private Set<Option> options; 
}
