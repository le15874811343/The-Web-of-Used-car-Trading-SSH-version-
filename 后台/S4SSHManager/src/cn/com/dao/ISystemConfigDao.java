package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;


public interface ISystemConfigDao {
	/**
	 * ��ȡ����ϵͳ��Ϣ
	 * @return
	 */
public Map<Long, Systemconfig> getAllSystemConfig();
/**
 * ͨ��Id��ȡϵͳ������Ϣ
 * @param systemConfig
 * @return
 */
public Systemconfig getSystemConfigById(Carinfo carInfo);
public int addSystemConfig(Systemconfig systemConfig);
public int updateSystemConfig(Systemconfig systemConfig);
public int deletesystemconfiguser(Systemconfig s);
public int deletecidsystemconfiguser(Systemconfig s);
public boolean checksystemconfiguser(Systemconfig s);
public boolean checkcidsystemconfiguser(Systemconfig s);


}
