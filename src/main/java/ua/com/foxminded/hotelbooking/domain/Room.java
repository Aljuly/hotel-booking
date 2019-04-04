package ua.com.foxminded.hotelbooking.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Data
@Entity
public class Room {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @NaturalId
    @Column(nullable = false, unique = true)
	private String roomNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    private RoomCategory roomCategory;
	
    @Column(nullable = false)
	private int beds;
	
    @Column(nullable = false)
	private BigDecimal costPerNight;
	
}
