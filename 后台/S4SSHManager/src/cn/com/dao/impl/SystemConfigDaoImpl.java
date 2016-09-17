package cn.com.dao.impl;

import java.util.*;
import java.sql.*;

import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;
import cn.com.util.DbUtil;
/**
 * 
 * 
 * 汽车系统配置信息操作实现类
 * @author lej
 */ 
public class SystemConfigDaoImpl extends BaseDao implements ISystemConfigDao{
        /**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub

		Map<Long, Systemconfig> systemConfigMap=new HashMap<Long, Systemconfig>();
		String sql=" from systemconfig";
	
		try {
	List<Systemconfig> slist=		super.getHibernateTemplate().find(sql); //获取结果集
	//遍历结果集，加入map中
	for(Systemconfig s:slist){
		systemConfigMap.put(s.getCId(), s);
	}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return systemConfigMap;
	}
/**
 * 通过Id获取系统信息
 * @param systemConfig
 * @return carInfo
 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Systemconfig systemConfig2=null;
		String sql="from Systemconfig where UId=? and CId=?";
		
		
		try {
			//获取结果
			systemConfig2=	 (Systemconfig) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemConfig2;
	}
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return int 
 */
@Override
public int addSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub
	 int count=0;
	 try{
		  super.getHibernateTemplate().save(systemConfig); //加入
		  count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	 }
	return count;
}
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return int 
 */
@Override
public int updateSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub

	StringBuffer sql=new StringBuffer("update  Systemconfig set guidancesystem=?,alb=?,fpg=?,rpg=?,rcpa=?,dsea=?,fsea=?,dlcc=?,hfs=?,hrs=?,fsv=?,rsv=?,fsm=?,rsm=?,rvmh=?,ess=? where UId=? and CId=? ");
	
	//返回受影响的行数
	return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{systemConfig.getGuidancesystem(),systemConfig.getAlb(),systemConfig.getFpg()
		,systemConfig.getRpg(),systemConfig.getRcpa(),systemConfig.getDsea(),systemConfig.getFsea(),systemConfig.getDlcc(),systemConfig.getHfs(),systemConfig.getHrs()
		,systemConfig.getFsv(),systemConfig.getRsv(),systemConfig.getFsm(),systemConfig.getRsm(),systemConfig.getRvmh(),systemConfig.getEss(),systemConfig.getUId(),systemConfig.getCId()});
}
/**
 * 根据车主编号删除汽车系统配置信息的方法
 *@return int  
 */
@Override
public int deletesystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	int count=0;
	String hql="from Systemconfig where UId=?";
List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql, s.getUId());//获取持久化对象集合
	try{
		for(Systemconfig _b:blist){
			super.getHibernateTemplate().delete(_b);//删除
		}
		
		count=1;
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return count;
}
/**
 * 根据车编号删除汽车系统配置信息的方法
 *@return int  
 */
@Override
public int deletecidsystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	int count=0;
	try{
		super.getHibernateTemplate().delete(s);//删除
		count=1;
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return count;
}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车系统配置信息
 * @return boolean
 */
@Override
public boolean checksystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	String hql="from Systemconfig where UId=?";
	boolean flag=false;
	List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql, s.getUId());//获取结果集
	if(blist.size()>0){
		flag=true;//若结果集元素个数大于0，则返回为真
	}
	return flag;
}
/**
 * 
 * 检查是否还有与某车编号关联的汽车系统配置信息
 * @return boolean
 */
@Override
public boolean checkcidsystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	String hql="from Systemconfig where CId=?";
	boolean flag=false;
	List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql,s.getCId());//获取结果集
	if(blist.size()>0){
		flag=true;//若结果集元素个数大于0，则返回为真
	}
	return flag;
}

}
