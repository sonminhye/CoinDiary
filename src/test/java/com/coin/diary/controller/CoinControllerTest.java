package com.coin.diary.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import com.coin.diary.entity.Coin;
import com.coin.diary.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CoinController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CoinControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CoinService service;
	
	@Autowired
	ObjectMapper obj;
	
	@Test
	@DisplayName("코인 가져오기 테스트")
	public void findCoinList() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/coin")
				   .contentType(MediaType.APPLICATION_JSON)
				   .accept(MediaType.APPLICATION_JSON));
	
		result.andDo(print())
		.andExpect(status().isOk())
		.andExpect(handler().handlerType(CoinController.class))
		.andExpect(handler().methodName("diary"))
		.andExpect(view().name("coin"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("coinList"));
	}
	
	@Test
	@DisplayName("코인 등록 테스트")
	public void addCoinListTest() throws JsonProcessingException, Exception {
		
		Coin coin = new Coin();
		coin.setMarketCode("UPBIT");
		coin.setCoinCode("ONT");
		coin.setCoinName("온톨로지");
		
		String jsonObj = obj.writeValueAsString(coin);
		
		ResultActions result = mockMvc.perform(post("/saveCoin")
				   .contentType(MediaType.APPLICATION_JSON)
				   .accept(MediaType.APPLICATION_JSON)
				   .content(jsonObj));
		
		
		result.andDo(print())
			.andExpect(status().isOk())
			.andExpect(handler().handlerType(CoinController.class))
			.andExpect(handler().methodName("coinSave"));
		
	}
	
}
