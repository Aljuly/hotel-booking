package ua.com.foxminded.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.foxminded.hotelbooking.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
