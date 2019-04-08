package ua.com.foxminded.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.com.foxminded.hotelbooking.domain.Option;
import ua.com.foxminded.hotelbooking.repository.OptionRepository;

@RestController
public class OptionController {

    @Autowired
    private OptionRepository optionRepository;
    
    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Option>> getAllOptions() {
        return new ResponseEntity<>(optionRepository.findAll(), HttpStatus.OK);
    }
}
