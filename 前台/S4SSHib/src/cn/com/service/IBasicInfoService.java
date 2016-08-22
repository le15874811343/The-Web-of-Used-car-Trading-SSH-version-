package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface IBasicInfoService {
	public Map<Long, Basicinfo> getAllBasic();
	public Basicinfo getAllBasicById(Carinfo carInfo);
	public boolean addBasicInfo(Basicinfo basicInfo);
	public boolean updateBasicInfo(Basicinfo basicInfo);
}
