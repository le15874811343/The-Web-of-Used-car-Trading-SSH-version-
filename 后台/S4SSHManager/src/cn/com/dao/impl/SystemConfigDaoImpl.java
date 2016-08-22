package cn.com.dao.impl;

import java.util.*;
import java.sql.*;

import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;
import cn.com.util.DbUtil;

public class SystemConfigDaoImpl extends BaseDao implements ISystemConfigDao{
	/**
	 * 获取所有系统信息
	 * @return
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
//		 private long u_id;
//		 private long c_id;
//		 private String guidanceSystem;
//		 private String alb;
//		 private String fpg;
//		 private String rpg;
//		 private String rcpa;
//		 private String dsea;
//		 private String fsea;
//		 private String dlcc;
//		 private String hfs;
//		 private String hrs;
//		 private String fsv;
//		 private String rsv;
//		 private String fsm;
//		 private String rsm;
//		 private String rvmh;
//		 private String ess;
		Map<Long, Systemconfig> systemConfigMap=new HashMap<Long, Systemconfig>();
		String sql=" from systemconfig";
	
		try {
	List<Systemconfig> slist=		super.getHibernateTemplate().find(sql);
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
 * 通过编号获取SystemConfig信息
 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Systemconfig systemConfig2=null;
		String sql="from Systemconfig where UId=? and CId=?";
		
		
		try {
			systemConfig2=	 (Systemconfig) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemConfig2;
	}
@Override
public int addSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub
	 int count=0;
	 try{
		  super.getHibernateTemplate().save(systemConfig);
		  count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	 }
	return count;
}
@Override
public int updateSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub

	StringBuffer sql=new StringBuffer("update  Systemconfig set guidancesystem=?,alb=?,fpg=?,rpg=?,rcpa=?,dsea=?,fsea=?,dlcc=?,hfs=?,hrs=?,fsv=?,rsv=?,fsm=?,rsm=?,rvmh=?,ess=? where UId=? and CId=? ");
	
	
	return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{systemConfig.getGuidancesystem(),systemConfig.getAlb(),systemConfig.getFpg()
		,systemConfig.getRpg(),systemConfig.getRcpa(),systemConfig.getDsea(),systemConfig.getFsea(),systemConfig.getDlcc(),systemConfig.getHfs(),systemConfig.getHrs()
		,systemConfig.getFsv(),systemConfig.getRsv(),systemConfig.getFsm(),systemConfig.getRsm(),systemConfig.getRvmh(),systemConfig.getEss(),systemConfig.getUId(),systemConfig.getCId()});
}
@Override
public int deletesystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	int count=0;
	String hql="from Systemconfig where UId=?";
List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql, s.getUId());
	try{
		for(Systemconfig _b:blist){
			super.getHibernateTemplate().delete(_b);
		}
		
		count=1;
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return count;
}
@Override
public int deletecidsystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	int count=0;
	try{
		super.getHibernateTemplate().delete(s);
		count=1;
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return count;
}
@Override
public boolean checksystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	String hql="from Systemconfig where UId=?";
	boolean flag=false;
	List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql, s.getUId());
	if(blist.size()>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean checkcidsystemconfiguser(Systemconfig s) {
	// TODO Auto-generated method stub
	String hql="from Systemconfig where CId=?";
	boolean flag=false;
	List<Systemconfig> blist=	 super.getHibernateTemplate().find(hql,s.getCId());
	if(blist.size()>0){
		flag=true;
	}
	return flag;
}

}
