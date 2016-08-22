package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;


public interface ICarImagesInfoDao {
public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
public int addCarImagesInfo(Imagesinfo carImagesInfo);
public int updateCarImagesInfo(Imagesinfo carImagesInfo);

}
