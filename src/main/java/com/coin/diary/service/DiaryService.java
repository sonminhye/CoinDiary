package com.coin.diary.service;

import java.util.List;

import com.coin.diary.entity.Diary;

public interface DiaryService {
	public List<Diary> findAll();
	public Diary find(Integer diaryNo);
	public void save(Diary diary);
}
