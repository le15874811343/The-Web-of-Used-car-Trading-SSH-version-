package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface IPriceIntervalService {
	public Map<Integer, Priceinterval> getPriceIntervalByCount();
	public boolean addPriceInterval(Priceinterval priceInterval);
	  public boolean deletePriceInterval(Priceinterval priceInterval);
	  public boolean updatePriceInterval(Priceinterval priceInterval);
	  public Priceinterval getPriceIntervalById(Priceinterval priceInterval);
}
