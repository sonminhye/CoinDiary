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
@Table(name="ROLE")
@Getter
@Setter
@ToString
public class Role {
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ROLE_CD")
	private Collection<UserRole> userRole;
	
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
