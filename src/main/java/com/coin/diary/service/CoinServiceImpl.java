package com.coin.diary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.diary.entity.Coin;
import com.coin.diary.repository.CoinRepository;

@Service
public class CoinServiceImpl implements CoinService{

	@Autowired
	private CoinRepository coinRepository;
	
	/*
	 * 모든 코인의 리스트를 반환
	 */
	@Override
	public List<Coin> findAll() {
		// TODO Auto-generated method stub
		return coinRepository.findAll();
	}

	/*
	 * 코인 입력
	 */
	@Override
	public void save(Coin coin) {
		// TODO Auto-generated method stub
		coinRepository.save(coin);
	}

	@Override
	public void saveAll(List<Coin> coinList) {
		// TODO Auto-generated method stub
		coinRepository.saveAll(coinList);
	}

	
}
