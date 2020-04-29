package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
@WebMvcTest
public class GoodbyeRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void givenARequest_WhenEmptyName_ThenGoodbyeWorld() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, World!")));
	}
	@Test
	public void givenARequest_WhenProvidedName_ThenGoodbyeName() throws Exception {
		this.mockMvc.perform(get("/goodbye?name=Cercei"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("content", equalTo("Goodbye, Cercei!")));
	}
	@Test
	public void givenARequest_WhenCorrectURL_ThenStatus200() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
		.andExpect(status().isOk());
	}
}
