package ua.com.foxminded.hotelbooking.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "RESERVATIONID")
	private UUID reservationId = UUID.randomUUID();
    
    @ManyToOne
    @JoinColumn
    private Room bookedRoom;
	
	@ManyToMany
    @JoinTable(
            name = "BOOKING_USERS",
            joinColumns = @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    )
	private Set<User> users = new HashSet<>();
	
	@Embedded
	@Valid
	private BookingDates bookingDates = new BookingDates();
	
	@ManyToMany
    @JoinTable(
            name = "BOOKING_OPTIONS",
            joinColumns = @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "OPTION_ID", referencedColumnName = "ID")
    )
	private Set<Option> options = new HashSet<>();
	
	@Column(name = "DATECREATED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

}
