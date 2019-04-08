package ua.com.foxminded.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.foxminded.hotelbooking.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
