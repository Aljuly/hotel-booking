package ua.com.foxminded.hotelbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ua.com.foxminded.hotelbooking.controller.UserController;
import ua.com.foxminded.hotelbooking.repository.UserRepository;
import ua.com.foxminded.hotelbooking.domain.User;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    private static final String URL = "/users";

    @InjectMocks
    UserController userController;
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(new UserController())
                .build();
    }
    
    @DisplayName("Should get all users")
    @Test
    public void shouldReturnAllUsers() throws Exception {
        // prepare mock behaviors
        List<User> userList = buildUsers();
        when(userRepository.findAll()).thenReturn(userList);
        // execute
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        // verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
        // verify that service method was called once
        verify(userRepository).findAll();
        // read List of users from Json Response
        TypeToken<List<User>> token = new TypeToken<List<User>>() {};
        @SuppressWarnings("unchecked")
        List<User> userResultList = (new Gson()).fromJson(result.getResponse().getContentAsString(), token.getType());
        assertNotNull(userResultList, "Users not found");
        assertEquals(userList.size(), userResultList.size(), "Incorrect User List");
    }
    
    private List<User> buildUsers() {
        User userOne = new User(1L, "Alan", "Lee");
        User userTwo = new User(2L, "Peeter", "Adams");
        return Arrays.asList(userOne, userTwo);
    }
}
