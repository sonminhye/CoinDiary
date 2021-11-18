package com.coin.diary;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {
	
	private static EntityManagerFactory emf;
	private EntityManagerUtils() {}
	
	public static synchronized EntityManagerFactory getInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("persistence-unit");
		}
		return emf;
	}
	
}
