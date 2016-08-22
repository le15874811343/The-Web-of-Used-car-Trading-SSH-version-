package cn.com.service.impl;

import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.ISellInfoDao;
import cn.com.dao.impl.SellInfoDaoImpl;
import cn.com.service.ISellInfoService;

public class SellInfoServiceImpl implements ISellInfoService{
private ISellInfoDao sellInfoDao=null;

	public ISellInfoDao getSellInfoDao() {
	return sellInfoDao;
}

public void setSellInfoDao(ISellInfoDao sellInfoDao) {
	this.sellInfoDao = sellInfoDao;
}

	@Override
	/**
	 * ��ȡ����������Ϣҵ��
	 */
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}

	@Override
	/**
	 * ���ݳ���Ż�ȡ�������ҵ��
	 */
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
	/**
	 * �����������ҵ��
	 */
	@Override
	public boolean addSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.addSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * ɾ���������ҵ��
	 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}

	@Override
	public boolean updateSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.updateSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}

}
