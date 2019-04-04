package ua.com.foxminded.hotelbooking.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class BookingDates {

	@Column(nullable = false)
    @NotNull(message = "Check in date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkInDate;

    @Column(nullable = false)
    @NotNull(message = "Check out date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    @NotNull(message = "Estimated check in time required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime estimatedCheckInTime;

}
