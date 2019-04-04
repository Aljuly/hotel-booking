package ua.com.foxminded.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;

import ua.com.foxminded.hotelbooking.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
