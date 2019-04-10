package ua.com.foxminded.hotelbooking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class BookingDates {

	@Column(name = "CHECKINDATE", nullable = false)
    @NotNull(message = "Check in date required")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date checkInDate;

    @Column(name = "CHECKOUTDATE", nullable = false)
    @NotNull(message = "Check out date required")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date checkOutDate;

}
