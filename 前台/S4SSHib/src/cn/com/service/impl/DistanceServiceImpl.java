package cn.com.service.impl;

import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class DistanceServiceImpl implements IDistanceService {
   private IDistanceDao distanceDao=null;
	public IDistanceDao getDistanceDao() {
	return distanceDao;
}
public void setDistanceDao(IDistanceDao distanceDao) {
	this.distanceDao = distanceDao;
}
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceByCount();
	}

}
