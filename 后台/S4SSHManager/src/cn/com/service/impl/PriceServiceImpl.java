package cn.com.service.impl;

import java.util.List;
import cn.com.pojo.Price;
import cn.com.dao.IPriceDao;
import cn.com.dao.impl.PriceDaoImpl;
import cn.com.service.IPriceService;

public class PriceServiceImpl implements IPriceService {
private IPriceDao priceDao=new PriceDaoImpl();
	@Override
	public  List<Price> getsellinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month, day);
	}

	@Override
	public List<Price> getsellinfo(int year, int month) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month);
	}

	@Override
	public  List<Price> getsellinfo(int year) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year);
	}

	@Override
	public List<Price> getsellinfo() {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo();
	}

}
