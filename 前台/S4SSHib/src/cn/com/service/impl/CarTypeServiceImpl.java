package cn.com.service.impl;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车型服务实现类
 * @author
 */
public class CarTypeServiceImpl  implements ICarTypeService{
	//车型操作接口的引用
   private ICarTypeDao carTypeDao=null;

public ICarTypeDao getCarTypeDao() {
	return carTypeDao;
}

public void setCarTypeDao(ICarTypeDao carTypeDao) {
	this.carTypeDao = carTypeDao;
}
        /**
	 * 按热度获取车型信息的服务
	 * @return Map<Integer,CarType>
	 */
@Override
public Map<Integer, Cartype> getCarTypeByCount() {
	// TODO Auto-generated method stub
	return carTypeDao.getCarTypeByCount();
}
        
        /**
	 * 获取所有车型信息的服务
	 * @return Map<Integer,CarType>
	 */
@Override
public Map<Integer, Cartype> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}
}
