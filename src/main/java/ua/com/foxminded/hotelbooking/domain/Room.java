package ua.com.foxminded.hotelbooking.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "ROOM")
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "NUMBER", nullable = false, unique = true)
	private String number;
    
    @OneToMany(mappedBy = "bookedRoom", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Booking> bookings;
    
    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private RoomCategory category;
	
    @Column(name = "BEDS", nullable = false)
	private int beds;
	
    @Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
}
