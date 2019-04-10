package ua.com.foxminded.hotelbooking.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ua.com.foxminded.hotelbooking.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {
	
	@Query(value = "select r.id, r.number, r.beds, r.price, c.id as category_id "
			+ "from Room r inner join Room_Category c on r.category_id = c.id "
			+ "where c.id = ?1", nativeQuery = true)
	public Iterable<Room> findByCategory(Long id);
	
	@Query(value = "select r.* from Room r where r.id not in "
			+ "(select b.roomId from booking b where (:start between b.checkInDate and b.checkOutDate) "
			+ "or (:end between b.checkInDate and b.checkOutDate))", nativeQuery = true)
	public Iterable<Room> findByDate(
			@Param("start") Date from,	
			@Param("end") Date to);
	
}
