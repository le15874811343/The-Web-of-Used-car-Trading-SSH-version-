package cn.com.service.impl;
import java.util.Map;
import cn.com.pojo.*;
import cn.com.dao.impl.*;
import cn.com.dao.*;
import cn.com.service.*;
public class CarBrandServiceImpl implements ICarBrandService {
  private ICarBrandDao brandDao= null;
	public ICarBrandDao getBrandDao() {
	return brandDao;
}
public void setBrandDao(ICarBrandDao brandDao) {
	this.brandDao = brandDao;
}
	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
		return brandDao.getCarBrandByCount();
	}
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}
	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByID(carBrand);
	}
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return  brandDao.getBrandByName(carBrand);
	}

}
