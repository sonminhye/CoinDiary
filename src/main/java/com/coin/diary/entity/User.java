package com.coin.diary.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USER")
@Getter
@Setter
@ToString
public class User {
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private Collection<UserRole> userRole;
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="KOR_NM")
	private String korNm;
	
	public User() {}
	
	@Builder
	public User(String userId, String password, String korNm) {
		this.userId = userId;
		this.password = password;
		this.korNm = korNm;
	}
}
