package com.coin.diary.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.coin.diary.EntityManagerUtils;
import com.coin.diary.entity.Diary;
import com.coin.diary.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService{

	
	//EntityManager em = EntityManagerUtils.getInstance().createEntityManager();
	
	@Autowired
	private DiaryRepository diaryRepository;
	
	@Override
	public List<Diary> findAll() {
		// TODO Auto-generated method stub
		return diaryRepository.findAll();
		
	}
	
	@Cacheable(value="diaryNo", key="#diaryNo")
	@Override
	public Diary find(Integer diaryNo) {
		// TODO Auto-generated method stub
		return diaryRepository.findById(diaryNo).get();
	}

	@Override
	public void save(Diary diary) {
		// TODO Auto-generated method stub
		diaryRepository.save(diary);
		//em.getTransaction().begin();
		//em.persist(diary);
		//em.getTransaction().commit();
	}
}
