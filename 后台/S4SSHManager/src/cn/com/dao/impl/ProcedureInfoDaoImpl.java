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

public class ProcedureInfoDaoImpl extends BaseDao implements IProcedureInfoDao{

	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
//		private long u_id;
//		 private long c_id;
//		 private String purchaseTax;
//		 private String drivingLicense;
//		 private String ncw;
//		 private String registration;
//		 private String newInvoice;
//		 private int key;
//		 private int transferTimes;
//		 private String transferTicket;
		String sql="from Procedureinfo";
		Map<Long, Procedureinfo> procedureInfoMap=new HashMap<Long, Procedureinfo>();
		try {
		List<Procedureinfo> plist=	super.getHibernateTemplate().find(sql);
		for(Procedureinfo p:plist){
			procedureInfoMap.put(p.getCId(), p);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfoMap;
	}

	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Procedureinfo procedureInfo2=null;
		String sql="from Procedureinfo where UId=? and CId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(carInfo.getUId());
		params.add(carInfo.getCId());
	
		try {
			procedureInfo2=	 (Procedureinfo) super.getHibernateTemplate().find(sql,new Object[]{carInfo.getUId(),carInfo.getCId()}).get(0);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfo2;
	}

	@Override
	public int addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(procedureInfo);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	
		
		return count;
	}

	@Override
	public int updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub

		StringBuffer sql=new StringBuffer("update  Procedureinfo set purchasetax=?,drivinglicense=?,ncw=?,registration=?,newinvoice=?,key=?,transfertimes=?,transferticket=? where UId=? and CId=? ");
	
		
		return super.getHibernateTemplate().bulkUpdate(sql.toString(),new Object[]{procedureInfo.getPurchasetax(),procedureInfo.getDrivinglicense()
				,procedureInfo.getNcw(),procedureInfo.getRegistration(),procedureInfo.getNewinvoice(),procedureInfo.getKey()
				,procedureInfo.getTransfertimes(),procedureInfo.getTransferticket(),procedureInfo.getUId(),procedureInfo.getCId()});
	}

	@Override
	public int deleteprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		int count=0;
		String hql="from Procedureinfo where UId=?";
	List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());
		try{
			for(Procedureinfo _b:blist){
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
	public int deletecidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(p);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		String hql="from Procedureinfo where UId=?";
		boolean flag=false;
		List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getUId());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkcidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		String hql="from Procedureinfo where CId=?";
		boolean flag=false;
		List<Procedureinfo> blist=	 super.getHibernateTemplate().find(hql, p.getCId());
		if(blist.size()>0){
			flag=true;
		}
		return flag;
	}

}
