package com.coin.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.CoinId;
import com.coin.diary.service.CoinService;

@Controller
public class CoinController {

	@Autowired
	private CoinService coinService;
	
	@RequestMapping("/coin")
	public String diary(@RequestParam("coinId") @Nullable CoinId coinId, Model model) {
		List<Coin> coinList = coinService.findAll();
		model.addAttribute("coinList", coinList);
		return "coin";
	}

	
	@PostMapping("/saveCoin")
	public @ResponseBody String coinSave(@RequestBody Coin coin, Model model) {
		coinService.save(coin);
		return "coin";
	}
	
}
