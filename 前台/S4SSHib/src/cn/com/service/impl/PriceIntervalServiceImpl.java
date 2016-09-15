package cn.com.service.impl;

import java.util.Map;

import cn.com.pojo.*;
import cn.com.dao.IPriceIntervalDao;
import cn.com.dao.impl.PriceIntervalDaoImpl;
import cn.com.service.IPriceIntervalService;
/**
 * 价格区间服务实现类
 * @author lej
 */
public class PriceIntervalServiceImpl implements IPriceIntervalService{
	//价格区间操作接口的引用
   private IPriceIntervalDao intervalDao=null;
   
	public IPriceIntervalDao getIntervalDao() {
	return intervalDao;
}

public void setIntervalDao(IPriceIntervalDao intervalDao) {
	this.intervalDao = intervalDao;
}
  /**
   * 
   * 按热度获取价格区间信息的服务
   * @return Map<Integer,PriceInterval>
   */
	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
	}

}
