package com.coin.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.diary.entity.Market;
import com.coin.diary.repository.MarketRepository;

@Service
public class MarketServiceImpl implements MarketService{

	@Autowired
	private MarketRepository marketRepository;


	@Override
	public void save(Market market) {
		// TODO Auto-generated method stub
		marketRepository.save(market);
	}


	@Override
	public List<Market> findAll() {
		// TODO Auto-generated method stub
		return marketRepository.findAll();
	}

	
}
