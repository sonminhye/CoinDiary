package com.coin.diary.service;

import java.util.List;

import com.coin.diary.entity.Coin;

public interface CoinService {
	public List<Coin> findAll();
	public void save(Coin coin);
	public void saveAll(List<Coin> coinList);
}
