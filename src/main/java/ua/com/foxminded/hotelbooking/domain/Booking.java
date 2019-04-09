package ua.com.foxminded.hotelbooking.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "RESERVATIONID")
	private UUID reservationId = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "ROOMID", referencedColumnName = "ID")
    private Room room;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
    private LocalDateTime dateCreated;

}
