package test.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.controller.EmployeeController;import net.minidev.json.JSONObject;
@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeController {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDummyEmployee() throws Exception{
		mockMvc.perform(get("/rest/emp/dummy"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		//.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$.id", is(9999)))
		.andExpect(jsonPath("$.name", is("Dummy")));
		//.andDo(JSONObject);
		//.andExpect(jsonPath("$[1].createdDate", is(1499837089388)))
		//.andExpect(jsonPath("$.createdDate", is(new Long(1499837089388l))));
		//verify(userService, times(1)).getAll();
		//verifyNoMoreInteractions(userService);	
		}
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	@Test
	public void testGetEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	private MockMvc mockMvc;
	
	private EmployeeController controller=new EmployeeController();

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(controller)
				.build();
	}

}
