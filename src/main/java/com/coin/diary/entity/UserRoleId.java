package com.coin.diary.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleId implements Serializable{
	
	private String username;
	private String roleCd;
	
}
