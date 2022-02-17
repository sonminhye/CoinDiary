package com.coin.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.CoinId;
import com.coin.diary.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
