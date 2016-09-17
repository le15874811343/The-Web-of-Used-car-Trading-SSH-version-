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
 * @return Map<Long, BasicInfo>
*/
	@Override
	public Map<Long, Basicinfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, Basicinfo> mapBasicInfo=new HashMap<Long, Basicinfo>();
		
	 String hql="from Basicinfo";
	List<Basicinfo> baslist=	super.getHibernateTemplate().find(hql);//获取结果集
	//遍历结果集，放于map中
	for(Basicinfo b:baslist){
		mapBasicInfo.put(b.getCId(), b);
	}
		
		return mapBasicInfo;
	}
/**
 *根据编号获取汽车基本信息的方法 
 *@return BasicInfo
 */
	@Override
	public Basicinfo getAllBasicById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Basicinfo basicInfo2=null;
	
		String hql="from Basicinfo where UId=? and CId=?";
		try{
			//获取结果
		basicInfo2=	 (Basicinfo) super.getHibernateTemplate().find(hql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
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
/**
 * 根据车主编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletebasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Basicinfo where UId=?";
		
	List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getUId()); //获取持久化对象
		try{
			for(Basicinfo _b:blist){
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
 * 根据车编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletecidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(b);   //删除
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
 * 检查是否还有与某车主编号关联的汽车基本信息
 * @return boolean
 */	
	@Override
	public boolean checkbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		String hql="from Basicinfo where UId=?";
		boolean flag=false;
		List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getUId()); //获取结果集
		if(blist.size()>0){
			flag=true;  //若结果集大于0，则返回为真
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车基本信息
 * @return boolean
 */
	@Override
	public boolean checkcidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String hql="from Basicinfo where CId=?";
				boolean flag=false;
				List<Basicinfo> blist=	 super.getHibernateTemplate().find(hql, b.getCId()); //获取结果集
				if(blist.size()>0){
					flag=true;  //若结果集大于0，则返回为真
				}
				return flag;
	}

}
