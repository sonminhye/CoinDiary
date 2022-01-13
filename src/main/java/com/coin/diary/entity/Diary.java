package com.coin.diary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="DIARY")
@Getter
@Setter
@ToString
public class Diary implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DIARY_NO")
	private Integer diaryNo;
	
	@Column(name="WRITE_DT")
	private String writeDt;
	
	@Column(name="INOUT")
	private String inout;
	
	@Column(name="INVEST_AMT")
	private String investAmt;
	
	@Column(name="AVG_PRICE")
	private String avgPrice;
	
	@Column(name="PROFIT_RATE")
	private String profitRate;
	
	@Column(name="PROFIT_AMT")
	private String profitAmt;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "MARKET_CODE"),
		@JoinColumn(name = "COIN_CODE")
	})
	private Coin coin;
	
}
