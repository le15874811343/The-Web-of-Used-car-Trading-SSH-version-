package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface ICarImagesInfoService {
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
	public boolean addCarImagesInfo(Imagesinfo carImagesInfo);
	public boolean updateCarImagesInfo(Imagesinfo carImagesInfo);
	
}
