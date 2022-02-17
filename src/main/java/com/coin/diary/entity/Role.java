package com.coin.diary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ROLE")
@Getter
@Setter
@ToString
public class Role {
	
	@Id
	@Column(name="ROLE_CD")
	private String roleCd;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	
	public Role() {}
	
	@Builder
	public Role(String roleCd, String roleName) {
		this.roleCd = roleCd;
		this.roleName = roleName;
	}
}
