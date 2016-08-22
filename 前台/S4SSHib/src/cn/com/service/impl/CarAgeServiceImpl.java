package cn.com.service.impl;
import java.util.Map;

import cn.com.pojo.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarAgeServiceImpl implements ICarAgeService {
  private ICarAgeDao carAgeDao=null;
  
	public ICarAgeDao getCarAgeDao() {
	return carAgeDao;
}

public void setCarAgeDao(ICarAgeDao carAgeDao) {
	this.carAgeDao = carAgeDao;
}

	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeByCount();
	}

}
