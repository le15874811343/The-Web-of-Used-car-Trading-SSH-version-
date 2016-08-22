package cn.com.service;

import java.util.Map;

import cn.com.pojo.*;

public interface ISystemConfigService {
	/**
	 * ��ȡ����SystemConfig��ϵ�ҵ��
	 * @return
	 */
	public Map<Long, Systemconfig> getAllSystemConfig();
	/**
	 * ͨ��u��ID��ȡSystemConfig
	 * @param systemConfig
	 * @return
	 */
	public Systemconfig getSystemConfigById(Carinfo carInfo);
	public boolean addSystemConfig(Systemconfig systemConfig);
	public boolean updateSystemConfig(Systemconfig systemConfig);
	 public boolean deletesystemconfiguser(Systemconfig s);
	 public boolean deletecidsystemconfiguser(Systemconfig s);
	 public boolean checksystemconfiguser(Systemconfig s);
	 public boolean checkcidsystemconfiguser(Systemconfig s);
}
