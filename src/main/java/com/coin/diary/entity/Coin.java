package com.coin.diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="COIN")
@Getter
@Setter
@IdClass(CoinId.class)
@ToString
public class Coin implements Serializable{
	
	@Id
	@Column(name="COIN_CODE")
	private String coinCode;
	
	@Id
	@Column(name="MARKET_CODE")
	private String marketCode;
	
	@Column(name="COIN_NAME")
	private String coinName;
	
}
