package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface IDistanceService {
	public Map<Integer, Distance> getDistanceByCount();
	 public boolean addDistance(Distance distance);
	   public boolean deleteDistance(Distance distance);
	   public boolean updateDistance(Distance distance);
	   public Distance getDistanceById(Distance distance);
}
