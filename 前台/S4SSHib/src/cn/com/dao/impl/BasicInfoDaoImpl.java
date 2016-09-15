package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import org.hibernate.Hibernate;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 汽车基本信息操作实现类
 * @author lej
 */
public class BasicInfoDaoImpl extends BaseDao implements IBasicInfoDao{
/**
 * 获取所有基本信息的方法
 * @return Map<Long, Basicinfo>
*/
	@Override
	public Map<Long, Basicinfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, Basicinfo> mapBasicInfo=new HashMap<Long, Basicinfo>();
		
	 String hql="from Basicinfo";
	List<Basicinfo> baslist=	super.getHibernateTemplate().find(hql);    //获取结果集
	//将结果添加进Map中
	for(Basicinfo b:baslist){  
		mapBasicInfo.put(b.getCId(), b);
	}
		
		return mapBasicInfo;
	}
/**
 *根据编号获取汽车基本信息的方法 
 *@return Basicinfo
 */
	@Override
	public Basicinfo getAllBasicById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Basicinfo basicInfo2=null;
	
		String hql="from Basicinfo where UId=? and CId=?";
		try{
		basicInfo2=(Basicinfo) super.getHibernateTemplate().find(hql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0); //获取结果
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return basicInfo2;
	}
/**
 * 添加汽车基本信息的方法
 * @return int
 */
	@Override
	public int addBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getHibernateTemplate().save(basicInfo); //添加进数据库中
		count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
/**
 * 修改汽车基本信息的方法
 * @return int
 */
	@Override
	public int updateBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		StringBuffer sql=new StringBuffer("update  Basicinfo set aidd=?,srdt=?,bodycolor=?,interiorcolor=?,domf=?,orgin=?,cimd=? where UId=? and CId=? ");
	      //返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{basicInfo.getAidd(),basicInfo.getSrdt(),basicInfo.getBodycolor(),basicInfo.getInteriorcolor(),
			basicInfo.getDomf(),basicInfo.getOrgin(),basicInfo.getCimd(),basicInfo.getUId(),basicInfo.getCId()});
	}

}
