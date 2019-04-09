package ua.com.foxminded.hotelbooking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.com.foxminded.hotelbooking.domain.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	@Query(value = "select b.* from booking b, booking_users u inner join u on u.booking_id = b.id"
			+ " where u.user_id = :userid", nativeQuery = true)
	public Iterable<Booking> findUserBooking(@Param("userid") Long id);
}
