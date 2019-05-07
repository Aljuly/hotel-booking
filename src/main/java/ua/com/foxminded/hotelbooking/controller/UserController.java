package ua.com.foxminded.hotelbooking.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.foxminded.hotelbooking.domain.User;
import ua.com.foxminded.hotelbooking.repository.UserRepository;

@RestController
@RequestMapping("/users")
@Api(value = "User")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    protected void verifyUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new ResourceNotFoundException("User with id " + userId + " not found!");
        }
    }
    
    @ApiOperation(value = "View a list of available users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieves all available users"),
            @ApiResponse(code = 500, message = "Server Error")
    })
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);        
    }
    
    @ApiOperation(value = "Retrieves an existing User")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Body: User data"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server Error")
    })
    @GetMapping("{userId}")
    public ResponseEntity<?> getUser(
            @ApiParam(value = "User id from which user object will retrieve", required = true) @PathVariable Long userId) {
        verifyUser(userId); 
        Optional<User> user = userRepository.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Create new User")
    @ApiResponses(value = { 
            @ApiResponse(code = 201, message = "Newly created user URI"),
            @ApiResponse(code = 500, message = "Server Error")
    })
    @PostMapping
    public ResponseEntity<?> createUser(
            @ApiParam(value = "User object to store in database table", required = true) @Valid @RequestBody User user) {
        user = userRepository.save(user);
        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(user.getId())
                .toUri();
        responseHeaders.setLocation(newUserUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
