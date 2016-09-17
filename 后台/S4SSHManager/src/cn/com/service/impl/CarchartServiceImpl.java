package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import cn.com.pojo.Carchart;
import cn.com.dao.ICarchartDao;
import cn.com.dao.impl.CarchartDaoImpl;
import cn.com.service.ICarchartService;
/**
 * 品牌销量服务实现类
 * 
 */
public class CarchartServiceImpl implements ICarchartService{
ICarchartDao carchartDao=new CarchartDaoImpl(); //品牌销量操作接口的引用
  /**
   * 按年月查询的服务
   * 
   */
	@Override 
	public List<Carchart> chartinfo(int year, int month) {
		// TODO Auto-generated method stub
		return carchartDao.chartinfo(year, month);
	}
/**
 * 查询不同年的服务
 * 
 */
	@Override
	public List<Carchart> chartinfo() {
		// TODO Auto-generated method stub
		return carchartDao.chartinfo();
	}
/**
 * 按年月日查询的服务
 * 
 */
	@Override
	public Map<String, Carchart> chartinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		return carchartDao.chartinfo(year, month, day);
	}
/**
 * 按年查询的服务
 * 
 */
	@Override
	public Map<String, Carchart> chartinfo(int year) {
		// TODO Auto-generated method stub
		return carchartDao.chartinfo(year);
	}

}
