package cn.com.service;
import java.util.*;


import cn.com.pojo.*;
public interface ITrendsService {
	public List<Trends> getITrendsByTime(Trends trends,int rows);
	public Trends getTrendsByWhere(Trends trends);
	
	public boolean addTrends(Trends trends);
	public boolean deleteTrends(Trends trends);
	public boolean updateTrends(Trends trends);
}
