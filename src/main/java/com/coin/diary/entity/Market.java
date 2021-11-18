package com.coin.diary.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="MARKET")
public class Market {

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="MARKET_CODE")
	private Collection<Coin> coins;
	
	@Id
	@Column(name="MARKET_CODE")
	private String marketCode;
	
	@Column(name="MARKET_NAME")
	private String marketName;
}
