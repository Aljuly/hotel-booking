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
import javax.validation.Valid;

import lombok.Data;

@Data
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private UUID reservationId = UUID.randomUUID();
	
	@OneToOne(mappedBy = "booking")
    private Room room;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "booking_users",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
	private Set<User> users = new HashSet<>();
	
	@Embedded
	@Valid
	private BookingDates bookingDates = new BookingDates();
	
	@ManyToMany
    @JoinTable(
            name = "booking_options",
            joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id")
    )
	private Set<Option> options = new HashSet<>();
	
	@Column(nullable = false)
    private LocalDateTime dateCreated;

}
