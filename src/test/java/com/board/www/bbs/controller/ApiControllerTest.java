package com.board.www.bbs.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.board.www.bbs.config.AppConfig.class)
public class ApiControllerTest {
	

	private MockMvc mvc;
	
	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(ApiController.class).build();
	}
	@Test
	public void review() throws Exception{
		String url = "http://localhost:8080/bbs/api/review/1";
		mvc.perform(MockMvcRequestBuilders.get(url))
		.andDo(MockMvcResultHandlers.print());
	}
}
