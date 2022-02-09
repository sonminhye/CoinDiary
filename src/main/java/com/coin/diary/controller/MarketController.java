package com.coin.diary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coin.diary.service.CoinService;
import com.coin.diary.service.MarketService;


@Controller
public class MarketController {
	
	@Autowired
	private MarketService marketService;
	
	@Autowired
	private CoinService coinService;
	
	@RequestMapping("/getMarketInfos")
	public String diary() {
		coinService.saveAll(marketService.getMarketInfoUpbitApi());
		return "coin";
	}

}
