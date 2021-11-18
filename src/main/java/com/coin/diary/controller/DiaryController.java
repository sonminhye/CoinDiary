package com.coin.diary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.Diary;
import com.coin.diary.service.CoinService;
import com.coin.diary.service.DiaryService;
import com.coin.diary.service.MarketService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	private CoinService coinService;
	
	@Autowired
	private MarketService marketService;
		
	@RequestMapping("/")
	public String diary(@RequestParam("diaryNo") @Nullable Integer diaryNo, Model model) {
		if(diaryNo != null) {
			Diary diary = diaryService.find(diaryNo);
			model.addAttribute("diary", diary);
			model.addAttribute("coin", diary.getCoin());
		}
		
		model.addAttribute("coinList", coinService.findAll()); // 코인조회
		model.addAttribute("marketList", marketService.findAll()); // 마켓 조회
		return "diary";
	}
	
	@RequestMapping(value="saveDiary", method = {RequestMethod.POST})
	public String savedDiary(@RequestBody Diary diary, RedirectAttributes ra) {
		diaryService.save(diary);
		ra.addAttribute("writeDt", diary.getWriteDt());
		return "redirect:/diaryList";
	}
	
	@RequestMapping(value="diaryList", method = {RequestMethod.GET})
	public String getDiaryList(@RequestParam("writeDt") @Nullable String writeDt, Model model) {  
		List<Diary> diaryList = diaryService.findAll();	
		for(int i = 0 ; i < diaryList.size(); i++) {
			Coin coin = diaryList.get(i).getCoin();
			System.out.println(coin.toString());
		}
		model.addAttribute("diaryList", diaryList);
		return "diaryList";
	}
	
}
