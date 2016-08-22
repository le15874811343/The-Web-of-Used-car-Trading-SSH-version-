package cn.com.service;
import java.util.Map;

import cn.com.pojo.*;

public interface ICarAgeService {
	public Map<Integer,Carage> getCarAgeByCount();
	public boolean addCarAge(Carage carAge);
	public boolean deleteCarAge(Carage carAge);
	public boolean updateCarAge(Carage carAge);
	public Carage getCarAgeById(Carage carAge);
}
