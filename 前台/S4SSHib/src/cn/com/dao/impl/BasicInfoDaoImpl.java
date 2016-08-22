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

}
