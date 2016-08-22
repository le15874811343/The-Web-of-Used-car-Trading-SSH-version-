package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarInfoServiceImpl implements ICarInfoService,IPageDao  {
   private ICarInfoDao carInfoDao=null;
   private IPageDao pageCar=null;
	public ICarInfoDao getCarInfoDao() {
	return carInfoDao;
}
public void setCarInfoDao(ICarInfoDao carInfoDao) {
	this.carInfoDao = carInfoDao;
}
public IPageDao getPageCar() {
	return pageCar;
}
public void setPageCar(IPageDao pageCar) {
	this.pageCar = pageCar;
}
	@Override
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByCountDesc(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrandCountDesc(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoBySjTime(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getFourthCarInfoBySjTime(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarInfoByTypeCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByTypeCountDesc(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrand(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByType(carInfo);
	}
	@Override
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarByWhere(carInfo);
	}
	@Override
	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return pageCar.queryMsgCount(object,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return pageCar.showMsgInfoList(curPage, rowsPrePage, object,order,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean addCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.addCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Carinfo getCarInfoByUMN(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByUMN(carInfo);
	}
	@Override
	public boolean updateCarAll(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarAll(carInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public List<Carinfo> getTenCount(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenCount(carInfo);
	}
	@Override
	public List<Carinfo> getTenBrandCar(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenBrandCar(carInfo);
	}

}
