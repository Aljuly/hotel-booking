package ua.com.foxminded.hotelbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ua.com.foxminded.hotelbooking.controller.UserController;
import ua.com.foxminded.hotelbooking.repository.UserRepository;
import ua.com.foxminded.hotelbooking.domain.User;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    private static final String URL = "/users/";
    private static final String GET_URL = "/users/1";

    @InjectMocks
    UserController userController;
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @DisplayName("Should get all users")
    @Test
    public void shouldReturnAllUsers() throws Exception {
        // prepare mock behaviors
        List<User> userList = buildUsers();
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        // execute
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        // verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
        // verify that service method was called once
        Mockito.verify(userRepository).findAll();
        // read List of users from Json Response
        TypeToken<List<User>> token = new TypeToken<List<User>>() {};
        List<User> userResultList = (new Gson()).fromJson(result.getResponse().getContentAsString(), token.getType());
        assertNotNull(userResultList, "Users not found");
        assertEquals(userList.size(), userResultList.size(), "Incorrect User List");
    }
    
    @DisplayName("Should append newly created user")
    @Test
    public void shouldAddUser() throws Exception {
    	// prepare mock behaviors
    	User userStub = new User(1L, "Ivan", "Drago");
    	Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(userStub);
    	// execute
        MvcResult result = mockMvc.perform(
        		MockMvcRequestBuilders.post(URL)
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content((new Gson()).toJson(userStub)))
        		.andReturn();
        // verify response
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status"); 
        // verify that service method was called once
        Mockito.verify(userRepository).save(Mockito.any(User.class));
        // analyze response
        // User resultUser = (new Gson()).fromJson(result.getResponse().getContentAsString(), User.class);
        // assertNotNull(resultUser, "User not appended");
        assertEquals("http://localhost/users/1", result.getResponse().getHeader(HttpHeaders.LOCATION));
        // assertEquals(1l, resultUser.getId().longValue(), "Incorrect User");
	}
    
    @DisplayName("Retrieve User bu Id")
    @Test
    public void shouldRetriveUserById() throws Exception {
		// prepare mock behaviors
    	User mockUser = new User(1L, "Ivan", "Drago");
    	Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(mockUser));
    	// execute
    	MvcResult result = mockMvc.perform(
    			MockMvcRequestBuilders.get(GET_URL)
    			.accept(MediaType.APPLICATION_JSON_UTF8))
    			.andReturn();
    	// verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
        // verify that service method was called once
        Mockito.verify(userRepository, times(2)).findById(Mockito.anyLong());
        // analyze response		
        User userResult = (new Gson()).fromJson(result.getResponse().getContentAsString(), User.class);
        assertNotNull(userResult, "User not found");
        assertEquals(mockUser.getFirstName(), userResult.getFirstName(), "Incorrect User");
	}
    
    private List<User> buildUsers() {
        User userOne = new User(1L, "Alan", "Lee");
        User userTwo = new User(2L, "Peeter", "Adams");
        return Arrays.asList(userOne, userTwo);
    }
}
