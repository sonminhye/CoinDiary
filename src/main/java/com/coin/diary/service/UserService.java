package com.coin.diary.service;

import java.util.List;

import com.coin.diary.entity.User;

public interface UserService {
	public List<User> findAll();
	public void save(User user);
}
