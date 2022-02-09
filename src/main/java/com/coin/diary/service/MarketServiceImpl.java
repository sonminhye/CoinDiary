package com.coin.diary.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.diary.entity.Coin;
import com.coin.diary.entity.Market;
import com.coin.diary.repository.MarketRepository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Service
public class MarketServiceImpl implements MarketService{

	@Autowired
	private MarketRepository marketRepository;


	@Override
	public void save(Market market) {
		// TODO Auto-generated method stub
		marketRepository.save(market);
	}


	@Override
	public List<Market> findAll() {
		// TODO Auto-generated method stub
		return marketRepository.findAll();
	}


	@Override
	public List<Coin> getMarketInfoUpbitApi() {
		// TODO Auto-generated method stub
		try {
			
			OkHttpClient client = new OkHttpClient();
	
			Request request = new Request.Builder()
			  .url("https://api.upbit.com/v1/market/all?isDetails=false")
			  .get()
			  .addHeader("Accept", "application/json")
			  .build();
	
			ResponseBody body = client.newCall(request).execute().body();
			return parseJsonText(body);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private List<Coin> parseJsonText(ResponseBody body){
		
		List<Coin> coinList = new ArrayList<Coin>();
		try {
			if (body != null) {
		        String jsonText = body.string();
		        body.close();
		        
				JSONArray array = (JSONArray) new JSONParser().parse(jsonText);
				
				for(Object o : array) {
					JSONObject obj = (JSONObject) o;
					Coin coin = Coin.builder().coinCode(obj.get("market").toString())
									.coinName(obj.get("korean_name").toString())
									.marketCode("UPBIT").build();
					
					coinList.add(coin);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coinList;
	}

	
}
