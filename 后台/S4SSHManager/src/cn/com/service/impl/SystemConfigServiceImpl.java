package cn.com.service.impl;

import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;

import cn.com.service.ISystemConfigService;

public class SystemConfigServiceImpl implements ISystemConfigService{
	private ISystemConfigDao systemConfigDao=null;
	
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}
	/**
	 * ��ȡ����SystemConfig��ϵ�ҵ��
	 * @return
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
	/**
	 * ͨ��u��ID��ȡSystemConfig
	 * @param systemConfig
	 * @return
	 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
	@Override
	public boolean addSystemConfig(Systemconfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.addSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
	@Override
	public boolean updateSystemConfig(Systemconfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.updateSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
	@Override
	public boolean deletesystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletesystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
	@Override
	public boolean deletecidsystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletecidsystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
	@Override
	public boolean checksystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checksystemconfiguser(s);
	}
	@Override
	public boolean checkcidsystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checkcidsystemconfiguser(s);
	}

}
