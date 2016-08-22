package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import org.hibernate.Hibernate;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;

public class BasicInfoDaoImpl extends BaseDao implements IBasicInfoDao{

	@Override
	public Map<Long, Basicinfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, Basicinfo> mapBasicInfo=new HashMap<Long, Basicinfo>();
		
	 String hql="from Basicinfo";
	List<Basicinfo> baslist=	super.getHibernateTemplate().find(hql);
	for(Basicinfo b:baslist){
		mapBasicInfo.put(b.getCId(), b);
	}
		
		return mapBasicInfo;
	}

	@Override
	public Basicinfo getAllBasicById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Basicinfo basicInfo2=null;
	
		String hql="from Basicinfo where UId=? and CId=?";
		try{
		basicInfo2=	 (Basicinfo) super.getHibernateTemplate().find(hql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return basicInfo2;
	}

	@Override
	public int addBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getHibernateTemplate().save(basicInfo);
		count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public int updateBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		StringBuffer sql=new StringBuffer("update  Basicinfo set aidd=?,srdt=?,bodycolor=?,interiorcolor=?,domf=?,orgin=?,cimd=? where UId=? and CId=? ");
	
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{basicInfo.getAidd(),basicInfo.getSrdt(),basicInfo.getBodycolor(),basicInfo.getInteriorcolor(),
			basicInfo.getDomf(),basicInfo.getOrgin(),basicInfo.getCimd(),basicInfo.getUId(),basicInfo.getCId()});
	}

	@Override
	public int deletebasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Basicinfo where UId=?";
		
	List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getUId());
		try{
			for(Basicinfo _b:blist){
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
	public int deletecidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(b);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean checkbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		String hql="from Basicinfo where UId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getUId());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkcidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="from Basicinfo where CId=?";
				boolean flag=false;
				List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getCId());
				if(blist.size()>0){
					flag=true;
				}
				return flag;
	}

}
