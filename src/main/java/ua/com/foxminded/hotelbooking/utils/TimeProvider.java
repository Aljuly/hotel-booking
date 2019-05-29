package ua.com.foxminded.hotelbooking.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeProvider {

    public Date localDateTime() {
        return Date.from(Instant.now());
    }

    public LocalDate localDate() {
        return LocalDate.now();
    }
}
