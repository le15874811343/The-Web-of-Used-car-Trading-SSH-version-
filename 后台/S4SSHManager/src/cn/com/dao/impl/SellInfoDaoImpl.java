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
/**
  * 
  * 销售信息操作实现类
  * @author lej
  */
public class SellInfoDaoImpl extends BaseDao implements ISellInfoDao{
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, SellInfo>
	 */
	@Override
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		String sql="from Sellinfo";
		Map<Long, Sellinfo> sellInfoMap=new HashMap<Long, Sellinfo>();
		
		try {
		List<Sellinfo> slist=	super.getHibernateTemplate().find(sql);//获取结果集
		//遍历结果集，加入map中
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
 * 根据车编号获取销售信息
 * @return SellInfo
 */
	@Override
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Sellinfo sellInfo2=null;
		String sql="from Sellinfo where UId=? and CId=?";
		
		try {
			//获取结果
			sellInfo2=	(Sellinfo) super.getHibernateTemplate().find(sql,new Object[]{ carInfo.getUId(),carInfo.getCId()}).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfo2;
	}
/**
 * 增加销售信息
 * @param sellInfo
 * @return int
 */
	@Override
	public int addSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getHibernateTemplate().save(sellInfo); //加入
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
/**
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getHibernateTemplate().delete(sellInfo); //删除
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
/**
 * 修改销售信息
 * @param sellInfo
 * @return int
 */
@Override
public int updateSellInfo(Sellinfo sellInfo) {
	// TODO Auto-generated method stub

	StringBuffer sql=new StringBuffer("update  Sellinfo set pricetype=?,transferfee=?,stage=? where UId=? and CId=?");
	
	
	//返回受影响的行数
	return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{sellInfo.getPricetype(),sellInfo.getTransferfee(),sellInfo.getStage()
		,sellInfo.getUId(),sellInfo.getCId()});
}
/**
 * 根据车主编号删除销售信息的方法
 *@return int  
 */
@Override
public int deletesellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	int count=0;
	String hql="from Sellinfo where UId=?";
List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getUId());//获取持久化对象集合
	try{
		for(Sellinfo _b:blist){
			super.getHibernateTemplate().delete(_b); //删除
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
 * 根据车编号删除销售信息的方法
 *@return int  
 */
@Override
public int deletecidsellinfouser(Sellinfo s) {
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
 * 检查是否还有与某车主编号关联的销售信息
 * @return boolean
 */
@Override
public boolean checksellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	String hql="from Sellinfo where UId=?";
	boolean flag=false;
	List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getUId());//获取结果集
	if(blist.size()>0){
		flag=true;//若结果集元素个数大于0，则返回为真
	}
	return flag;
}
/**
 * 
 * 检查是否还有与某车编号关联的销售信息
 * @return boolean
 */
@Override
public boolean checkcidsellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	String hql="from Sellinfo where CId=?";
	boolean flag=false;
	List<Sellinfo> blist=	 super.getHibernateTemplate().find(hql, s.getCId());//获取结果集
	if(blist.size()>0){
		flag=true;//若结果集元素个数大于0，则返回为真
	}
	return flag;
}

}
