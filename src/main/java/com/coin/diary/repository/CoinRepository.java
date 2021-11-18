package com.coin.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.CoinId;

public interface CoinRepository extends JpaRepository<Coin, CoinId>{

}
