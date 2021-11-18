package com.coin.diary.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.diary.entity.*;

public interface MarketRepository extends JpaRepository<Market, String>{
	
}
