package com.coin.diary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USER_ROLE")
@Getter
@Setter
@ToString
@IdClass(UserRoleId.class)
public class UserRole {
	
	@Id
	@Column(name="USER_NAME")
	private String username;
	
	@Id
	@Column(name="ROLE_CD")
	private String roleCd;

}
