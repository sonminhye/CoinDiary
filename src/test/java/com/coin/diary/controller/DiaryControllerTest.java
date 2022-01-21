package com.coin.diary.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.Diary;
import com.coin.diary.service.CoinService;
import com.coin.diary.service.DiaryService;
import com.coin.diary.service.MarketService;


@WebMvcTest(DiaryController.class)
@RunWith(MockitoJUnitRunner.class)
public class DiaryControllerTest {

	MockMvc mockMvc;
	
	@InjectMocks
	DiaryController controller;
	
	@Mock
	DiaryService diaryService;
	
	@Mock
	private CoinService coinService;
	
	@Mock
	private MarketService marketService;
		
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	@DisplayName("다이어리 가져오기(특정 다이어리 존재할 시)")
	public void testDiaryWhenDiaryExists() throws Exception {
		
		// given
		Diary diary = new Diary();
		diary.setDiaryNo(1);
		diary.setCoin(Coin.builder().marketCode("UPBIT")
				  .coinCode("ONT")
				  .coinName("온톨로지")
				  .build());
		
		when(diaryService.find(1)).thenReturn(diary);
		
		// result
		ResultActions result = mockMvc.perform(get("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.param("diaryNo", "1")); // 1번 
		
		
		result.andDo(print())
				.andExpect(status().isOk())
				.andExpect(handler().handlerType(DiaryController.class))
				.andExpect(handler().methodName("diary"))
				.andExpect(view().name("diary"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("coin"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("diary"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("coinList"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("marketList"));
	}
	

	@Test
	@DisplayName("다이어리 가져오기 (다이어리 존재하지 않을 때)")
	public void testDiary() throws Exception {
		
		ResultActions result = mockMvc.perform(get("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));
		
		result.andDo(print())
				.andExpect(status().isOk())
				.andExpect(handler().handlerType(DiaryController.class))
				.andExpect(handler().methodName("diary"))
				.andExpect(view().name("diary"))
				.andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("coin"))
				.andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("diary"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("coinList"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("marketList"));
	}

	@Test
	public void testSavedDiary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiaryList() {
		fail("Not yet implemented");
	}

}
