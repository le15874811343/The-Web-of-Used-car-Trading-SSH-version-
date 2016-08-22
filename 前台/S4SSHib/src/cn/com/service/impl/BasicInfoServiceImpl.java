package cn.com.service.impl;

import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.IBasicInfoDao;
import cn.com.dao.impl.*;
import cn.com.service.*;

public class BasicInfoServiceImpl implements IBasicInfoService{
private IBasicInfoDao basicInfoDaoImpl=null;

public IBasicInfoDao getBasicInfoDaoImpl() {
	return basicInfoDaoImpl;
}

public void setBasicInfoDaoImpl(IBasicInfoDao basicInfoDaoImpl) {
	this.basicInfoDaoImpl = basicInfoDaoImpl;
}

@Override
public Map<Long, Basicinfo> getAllBasic() {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasic();
}

@Override
public Basicinfo getAllBasicById(Carinfo carInfo) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasicById(carInfo);
}

@Override
public boolean addBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.addBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.updateBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}
	
	
}
