package com.springj.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springj.services.Student;
import com.springj.services.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SampleComtroller.class)
@WithMockUser
public class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	StudentService service;

	@Test
	public void testGetIngo() throws Exception {

		Student mockStudent = new Student("TestName", "TestSurname");

		Mockito.when(service.getInfo()).thenReturn(mockStudent);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ping/Mayur")
				.accept(MediaType.APPLICATION_JSON_VALUE);
		
		MvcResult mvcResult =  mockMvc.perform(requestBuilder).andReturn();
		
		String actualResponse = mvcResult.getResponse().getContentAsString();
		
		String expectedResponse = "{\"name\":\"TestName\",\"surname\":\"TestSurname\"}";
		
		assertEquals(expectedResponse, actualResponse);
	}

}
