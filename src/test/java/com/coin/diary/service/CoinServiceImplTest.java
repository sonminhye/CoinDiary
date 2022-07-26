package com.coin.diary.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoinServiceImplTest {

	@Autowired
	private CoinService coinService;
	
	@Test
	@DisplayName("모든코인 찾기 테스트")
	void findAllTest() {
		
	}
}
