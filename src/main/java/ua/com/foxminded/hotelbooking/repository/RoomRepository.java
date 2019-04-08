package ua.com.foxminded.hotelbooking.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.com.foxminded.hotelbooking.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	
	public Iterable<Room> findByCategory(Long id);
	
	@Query(value = "select r.* from Room r where r.id not in "
			+ "(select b.roomId from booking b where (:start between b.checkIn and b.checkOut) "
			+ "or (:end between b.checkIn and b.checkOut))", nativeQuery = true)
	public Iterable<Room> findByDate(@Param("start") Date from,	@Param("end") Date to);
	
}
