package com.customerservice.CustomerService;

import com.customerservice.CustomerService.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setup() {

	}

	@Test
	public void givenCustomers_whenMockMVC_thenReturnsCustomers() throws Exception {
		mockMvc.perform(get("/api/customers"))
				.andExpect(status().isOk());

//		MvcResult mvcResult = this.mockMvc.perform(get("/greet"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.message").value("Hello World!!!"))
//				.andReturn();
//
//		assertEquals("application/json;charset=UTF-8",
//				mvcResult.getResponse().getContentType());

	}


}
