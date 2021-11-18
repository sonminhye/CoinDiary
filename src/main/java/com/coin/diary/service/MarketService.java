package com.coin.diary.service;

import java.util.List;

import com.coin.diary.entity.Market;

public interface MarketService {
	public List<Market> findAll();
	public void save(Market coin);
}
