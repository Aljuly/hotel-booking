package ua.com.foxminded.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.foxminded.hotelbooking.domain.Option;
import ua.com.foxminded.hotelbooking.repository.OptionRepository;

@RestController("/options")
@Api(value = "Options")
public class OptionController {

    @Autowired
    private OptionRepository optionRepository;
    
    @GetMapping
    @ApiOperation(value = "Get list of available options", response = List.class)
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Successfully retrieved list"),
    		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Iterable<Option>> getAllOptions() {
        return new ResponseEntity<>(optionRepository.findAll(), HttpStatus.OK);
    }
}
