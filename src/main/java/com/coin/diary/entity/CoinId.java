package com.coin.diary.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoinId implements Serializable{
	private String coinCode;
	private String marketCode;
}
