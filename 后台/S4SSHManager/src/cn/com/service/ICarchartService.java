package cn.com.service;

import java.util.List;
import java.util.Map;



import cn.com.pojo.Carchart;

public interface ICarchartService {
	public List<Carchart> chartinfo(int year,int month);
	public List<Carchart> chartinfo();
	public Map<String, Carchart> chartinfo(int year, int month, int day);
	public Map<String, Carchart> chartinfo(int year);
}
