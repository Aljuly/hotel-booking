package ua.com.foxminded.hotelbooking.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    
    @OneToOne
    @JoinColumn(name = "ROOMID")
    private Booking booking;
    
    @OneToOne(cascade = CascadeType.ALL)
    private RoomCategory roomCategory;
	
    @Column(name = "BEDS", nullable = false)
	private int beds;
	
    @Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
}
