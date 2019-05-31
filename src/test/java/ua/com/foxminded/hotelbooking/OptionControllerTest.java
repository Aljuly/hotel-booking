package ua.com.foxminded.hotelbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ua.com.foxminded.hotelbooking.controller.OptionController;
import ua.com.foxminded.hotelbooking.domain.Option;
import ua.com.foxminded.hotelbooking.repository.OptionRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OptionController.class)
public class OptionControllerTest {

	private static final String URL = "/options";

	@InjectMocks
	OptionController optionController;
	
	@MockBean
	private OptionRepository optionRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("Return list of available options")
	@Test
	public void shouldReturnAvailableOptions() throws Exception {
		// prepare mocks
		List<Option> mockOptions = buildOptions();
		Mockito.when(optionRepository.findAll()).thenReturn(mockOptions);
		// execute
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        // verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
        // verify that service method was called once
        Mockito.verify(optionRepository).findAll();
        // read List of users from Json Response
        TypeToken<List<Option>> token = new TypeToken<List<Option>>() {};
        List<Option> optionsResultList = (new Gson()).fromJson(result.getResponse().getContentAsString(), token.getType());
        assertNotNull(optionsResultList, "Users not found");
        assertEquals(mockOptions.size(), optionsResultList.size(), "Incorrect User List");
	}
	
	private List<Option> buildOptions() {
		Option optionOne = new Option(1, "OptionOne", 10);
		Option optionTwo = new Option(2, "OptionTwo", 20);
		return Arrays.asList(optionOne, optionTwo);
	}
}
