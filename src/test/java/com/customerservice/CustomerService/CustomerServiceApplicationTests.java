package com.customerservice.CustomerService;
import com.customerservice.CustomerService.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void getAllCustomers() throws Exception {
		String actualCustomerList = mockMvc.perform(get("/api/customers"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		assertThat(actualCustomerList).isNotEmpty();
	}

	@Test
	public void addCustomer() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String newCustomer = mapper.writeValueAsString(new Customer(
				"Salvator", "Di'Mario", "510-555-7863","45 Carver Ave, Midland, TX 70134"));
		mockMvc.perform(post("/api/customers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newCustomer)
		       ).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").isNotEmpty())
				.andExpect(jsonPath("$.firstName").value("Salvator"))
				.andExpect(jsonPath("$.lastName").value("Di'Mario"))
				.andExpect(jsonPath("$.phoneNumber").value("510-555-7863"))
				.andExpect(jsonPath("$.address").value("45 Carver Ave, Midland, TX 70134"));
	}

}
