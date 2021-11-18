package com.coin.diary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.diary.entity.*;

public interface DiaryRepository extends JpaRepository<Diary, Integer>{
	
	List<Diary> findByWriteDt(String writeDt);
	
}
