package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.ISellInfoDao;
import cn.com.util.DbUtil;

public class SellInfoDaoImpl extends BaseDao implements ISellInfoDao{
/**
 * ��ȡ����������Ϣ
 */
//	private long u_id;
//	 private long c_id;
//	 private String priceType;
//	 private String transferFee;
//	 private String stage;
	@Override
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		String sql="from Sellinfo";
		Map<Long, Sellinfo> sellInfoMap=new HashMap<Long, Sellinfo>();
		
		try {
		List<Sellinfo> slist=	super.getHibernateTemplate().find(sql);
		for(Sellinfo s:slist){
			sellInfoMap.put(s.getCId(), s);
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfoMap;
	}
/**
 * ���ݳ���Ż�ȡ�������
 */
	@Override
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Sellinfo sellInfo2=null;
		String sql="from Sellinfo where UId=? and CId=?";
		
		try {
			sellInfo2=	(Sellinfo) super.getHibernateTemplate().find(sql,new Object[]{ carInfo.getUId(),carInfo.getCId()}).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfo2;
	}
/**
 * �����������
 */
	@Override
	public int addSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getHibernateTemplate().save(sellInfo);
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
/**
 * ɾ���������
 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getHibernateTemplate().delete(sellInfo);
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
@Override
public int updateSellInfo(Sellinfo sellInfo) {
	// TODO Auto-generated method stub

	StringBuffer sql=new StringBuffer("update  Sellinfo set pricetype=?,transferfee=?,stage=? where UId=? and CId=?");
	
	
	
	return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{sellInfo.getPricetype(),sellInfo.getTransferfee(),sellInfo.getStage()
		,sellInfo.getUId(),sellInfo.getCId()});
}
@Override
public int deletesellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	int count=0;
	String hql="from Sellinfo where UId=?";
List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getUId());
	try{
		for(Sellinfo _b:blist){
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
public int deletecidsellinfouser(Sellinfo s) {
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
public boolean checksellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	String hql="from Sellinfo where UId=?";
	boolean flag=false;
	List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getUId());
	if(blist.size()>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean checkcidsellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	String hql="from Sellinfo where CId=?";
	boolean flag=false;
	List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getCId());
	if(blist.size()>0){
		flag=true;
	}
	return flag;
}

}
