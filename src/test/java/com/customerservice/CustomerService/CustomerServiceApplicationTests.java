package com.customerservice.CustomerService;
import com.customerservice.CustomerService.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceApplicationTests {

	ObjectMapper mapper;
	ArrayList<Customer> customerList;

	@Autowired
	MockMvc mockMvc;

	String customersJsonPath = "src/test/data/customers.json"; // 4 customers
	String customerJsonPath = "src/test/data/existingCustomer.json"; // 1 customer
	String newCustomerJsonPath = "src/test/data/newCustomer.json"; // 1 customer


	@BeforeEach
	void setUp() throws IOException {
		initializeCustomersData();
	}

	// TEST UTILITIES ----------------------------------------------------

	private void initializeCustomersData() throws IOException {
		mapper = new ObjectMapper();
		File customersFile = new File(customersJsonPath);
		customerList = mapper.readValue(customersFile, new TypeReference<ArrayList<Customer>>() {});
	}

	private String getCustomerJsonString() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File customerFile = new File(customerJsonPath);
		Customer customer = mapper.readValue(customerFile, Customer.class);
		return mapper.writeValueAsString(customer);
	}

	private String createCustomerJsonString() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File customerFile = new File(newCustomerJsonPath);
		Customer customer = mapper.readValue(customerFile, Customer.class);
		return mapper.writeValueAsString(customer);
	}

	@Test
	public void givenCustomers_whenMockMVC_thenReturnsCustomers() throws Exception {
		String actualCustomerList = mockMvc.perform(get("/api/customers"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		String expectedCustomerList = mapper.writeValueAsString(new ArrayList<Customer>()); //TODO - customerList returns String ID
		Assertions.assertEquals(expectedCustomerList,actualCustomerList);
	}

	@Test
	public void getCustomerById() throws Exception {
		mockMvc.perform(get("/api/customers/b8a504e8-7cbd-4a54-9a24-dc1832558162"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id"). value("b8a504e8-7cbd-4a54-9a24-dc1832558162"))
				.andExpect( jsonPath("$.firstName").value("Qin"))
				.andExpect( jsonPath("$.lastName").value("Zhang"))
				.andExpect( jsonPath("$.address").value("1 Main Street, Topeka, KS 37891"))
				.andExpect( jsonPath("$.phoneNumber").value("510-555-2367"));

	}
}
