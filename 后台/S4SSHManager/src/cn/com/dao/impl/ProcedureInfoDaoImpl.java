package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;
import cn.com.util.DbUtil;
/**
 * 手续信息操作实现类
 * @author lej
 */
public class ProcedureInfoDaoImpl extends BaseDao implements IProcedureInfoDao{
  /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		String sql="from Procedureinfo";
		Map<Long, Procedureinfo> procedureInfoMap=new HashMap<Long, Procedureinfo>();
		try {
		List<Procedureinfo> plist=	super.getHibernateTemplate().find(sql);//获取结果集
		//遍历结果集，加入map中
		for(Procedureinfo p:plist){
			procedureInfoMap.put(p.getCId(), p);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfoMap;
	}
  /**
   * 
   * 根据编号获取手续信息的方法
   *@return ProcedureInfo
   */
	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Procedureinfo procedureInfo2=null;
		String sql="from Procedureinfo where UId=? and CId=?";
		try {
			//获取结果
			procedureInfo2=	 (Procedureinfo) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfo2;
	}
  /**
   * 
   * 添加手续信息的方法
   *@return int
   */
	@Override
	public int addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(procedureInfo); //加入
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
   * 修改手续信息的方法
   *@return  int
   */
	@Override
	public int updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub

		StringBuffer sql=new StringBuffer("update  Procedureinfo set purchasetax=?,drivinglicense=?,ncw=?,registration=?,newinvoice=?,key=?,transfertimes=?,transferticket=? where UId=? and CId=? ");
	
		 //返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{procedureInfo.getPurchasetax(),procedureInfo.getDrivinglicense()
				,procedureInfo.getNcw(),procedureInfo.getRegistration(),procedureInfo.getNewinvoice(),procedureInfo.getKey()
				,procedureInfo.getTransfertimes(),procedureInfo.getTransferticket(),procedureInfo.getUId(),procedureInfo.getCId()});
	}
/**
 * 根据车主编号删除手续信息的方法
 *@return int  
 */
	@Override
	public int deleteprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Procedureinfo where UId=?";
	List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());//获取持久化结果集合
		try{
			for(Procedureinfo _b:blist){
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
 * 根据车编号删除手续信息的方法
 *@return int  
 */
	@Override
	public int deletecidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(p);//删除
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
 * 检查是否还有与某车主编号关联的手续信息
 * @return boolean
 */
	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		String hql="from Procedureinfo where UId=?";
		boolean flag=false;
		List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());//获取结果集
		if(blist.size()>0){
			flag=true;//若结果集元素个数大于0则返回为真
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的手续信息
 * @return boolean
 */
	@Override
	public boolean checkcidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		String hql="from Procedureinfo where CId=?";
		boolean flag=false;
		List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCId());//获取结果集
		if(blist.size()>0){
			flag=true; //若结果集元素个数大于0则返回为真
		}
		return flag;
	}

}
